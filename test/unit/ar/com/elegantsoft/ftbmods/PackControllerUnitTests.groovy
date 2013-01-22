package ar.com.elegantsoft.ftbmods



import org.junit.*
import grails.test.mixin.*

@TestFor(PackController)
@Mock(Pack)
class PackControllerUnitTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/pack/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.packInstanceList.size() == 0
        assert model.packInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.packInstance != null
    }

    void testSave() {
        controller.save()

        assert model.packInstance != null
        assert view == '/pack/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/pack/show/1'
        assert controller.flash.message != null
        assert Pack.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/pack/list'

        populateValidParams(params)
        def pack = new Pack(params)

        assert pack.save() != null

        params.id = pack.id

        def model = controller.show()

        assert model.packInstance == pack
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/pack/list'

        populateValidParams(params)
        def pack = new Pack(params)

        assert pack.save() != null

        params.id = pack.id

        def model = controller.edit()

        assert model.packInstance == pack
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/pack/list'

        response.reset()

        populateValidParams(params)
        def pack = new Pack(params)

        assert pack.save() != null

        // test invalid parameters in update
        params.id = pack.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/pack/edit"
        assert model.packInstance != null

        pack.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/pack/show/$pack.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        pack.clearErrors()

        populateValidParams(params)
        params.id = pack.id
        params.version = -1
        controller.update()

        assert view == "/pack/edit"
        assert model.packInstance != null
        assert model.packInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/pack/list'

        response.reset()

        populateValidParams(params)
        def pack = new Pack(params)

        assert pack.save() != null
        assert Pack.count() == 1

        params.id = pack.id

        controller.delete()

        assert Pack.count() == 0
        assert Pack.get(pack.id) == null
        assert response.redirectedUrl == '/pack/list'
    }
}
