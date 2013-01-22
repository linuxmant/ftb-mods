package ar.com.elegantsoft.ftbmods

import org.springframework.dao.DataIntegrityViolationException

class PackController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [packInstanceList: Pack.list(params), packInstanceTotal: Pack.count()]
    }

    def create() {
        [packInstance: new Pack(params)]
    }

    def save() {
        def packInstance = new Pack(params)
        if (!packInstance.save(flush: true)) {
            render(view: "create", model: [packInstance: packInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'pack.label', default: 'Pack'), packInstance.id])
        redirect(action: "show", id: packInstance.id)
    }

    def show(Long id) {
        def packInstance = Pack.get(id)
        if (!packInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'pack.label', default: 'Pack'), id])
            redirect(action: "list")
            return
        }

        [packInstance: packInstance]
    }

    def edit(Long id) {
        def packInstance = Pack.get(id)
        if (!packInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'pack.label', default: 'Pack'), id])
            redirect(action: "list")
            return
        }

        [packInstance: packInstance]
    }

    def update(Long id, Long version) {
        def packInstance = Pack.get(id)
        if (!packInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'pack.label', default: 'Pack'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (packInstance.version > version) {
                packInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'pack.label', default: 'Pack')] as Object[],
                          "Another user has updated this Pack while you were editing")
                render(view: "edit", model: [packInstance: packInstance])
                return
            }
        }

        packInstance.properties = params

        if (!packInstance.save(flush: true)) {
            render(view: "edit", model: [packInstance: packInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'pack.label', default: 'Pack'), packInstance.id])
        redirect(action: "show", id: packInstance.id)
    }

    def delete(Long id) {
        def packInstance = Pack.get(id)
        if (!packInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'pack.label', default: 'Pack'), id])
            redirect(action: "list")
            return
        }

        try {
            packInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'pack.label', default: 'Pack'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'pack.label', default: 'Pack'), id])
            redirect(action: "show", id: id)
        }
    }
}
