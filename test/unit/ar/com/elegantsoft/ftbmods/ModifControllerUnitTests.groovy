package ar.com.elegantsoft.ftbmods



import org.junit.*
import grails.test.mixin.*

@TestFor(ModifController)
@Mock(Modif)
class ModifControllerUnitTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/mod/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.modInstanceList.size() == 0
        assert model.modInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.modInstance != null
    }

    void testSave() {
        controller.save()

        assert model.modInstance != null
        assert view == '/mod/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/mod/show/1'
        assert controller.flash.message != null
        assert Modif.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/mod/list'

        populateValidParams(params)
        def mod = new Modif(params)

        assert mod.save() != null

        params.id = mod.id

        def model = controller.show()

        assert model.modInstance == mod
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/mod/list'

        populateValidParams(params)
        def mod = new Modif(params)

        assert mod.save() != null

        params.id = mod.id

        def model = controller.edit()

        assert model.modInstance == mod
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/mod/list'

        response.reset()

        populateValidParams(params)
        def mod = new Modif(params)

        assert mod.save() != null

        // test invalid parameters in update
        params.id = mod.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/mod/edit"
        assert model.modInstance != null

        mod.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/mod/show/$mod.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        mod.clearErrors()

        populateValidParams(params)
        params.id = mod.id
        params.version = -1
        controller.update()

        assert view == "/mod/edit"
        assert model.modInstance != null
        assert model.modInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/mod/list'

        response.reset()

        populateValidParams(params)
        def mod = new Modif(params)

        assert mod.save() != null
        assert Modif.count() == 1

        params.id = mod.id

        controller.delete()

        assert Modif.count() == 0
        assert Modif.get(mod.id) == null
        assert response.redirectedUrl == '/mod/list'
    }
}
