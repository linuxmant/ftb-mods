package ar.com.elegantsoft.ftbmods

import org.springframework.dao.DataIntegrityViolationException

class ModifController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [modInstanceList: Modif.list(params), modInstanceTotal: Modif.count()]
    }

    def create() {
        [modInstance: new Modif(params)]
    }

    def save() {
        def modInstance = new Modif(params)
        if (!modInstance.save(flush: true)) {
            render(view: "create", model: [modInstance: modInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'mod.label', default: 'Mod'), modInstance.id])
        redirect(action: "show", id: modInstance.id)
    }

    def show(Long id) {
        def modInstance = Modif.get(id)
        if (!modInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'mod.label', default: 'Mod'), id])
            redirect(action: "list")
            return
        }

        [modInstance: modInstance]
    }

    def edit(Long id) {
        def modInstance = Modif.get(id)
        if (!modInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'mod.label', default: 'Mod'), id])
            redirect(action: "list")
            return
        }

        [modInstance: modInstance]
    }

    def update(Long id, Long version) {
        def modInstance = Modif.get(id)
        if (!modInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'mod.label', default: 'Mod'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (modInstance.version > version) {
                modInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'mod.label', default: 'Mod')] as Object[],
                          "Another user has updated this Mod while you were editing")
                render(view: "edit", model: [modInstance: modInstance])
                return
            }
        }

        modInstance.properties = params

        if (!modInstance.save(flush: true)) {
            render(view: "edit", model: [modInstance: modInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'mod.label', default: 'Mod'), modInstance.id])
        redirect(action: "show", id: modInstance.id)
    }

    def delete(Long id) {
        def modInstance = Modif.get(id)
        if (!modInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'mod.label', default: 'Mod'), id])
            redirect(action: "list")
            return
        }

        try {
            modInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'mod.label', default: 'Mod'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'mod.label', default: 'Mod'), id])
            redirect(action: "show", id: id)
        }
    }
}
