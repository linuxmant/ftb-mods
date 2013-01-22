package ar.com.elegantsoft.ftbmods

import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Item)
class ItemUnitTests {
	def item

	@Before
	void setUp() {
		item = new Item(name:'testItem', priId:1, secId:0, pic:'test', mod:0)
	}
	
	@After
	void tearDown() {
		item = null;
	}
	
    void testGetPriId() {
		assertEquals '1', item.priId
    }
	
	void testSetPriId() {
		def i = new Item(name:'test2', priId:4, secId:2, pic:'pictest', mod:0)
		assertEquals '4', i.priId
		
		i.priId = 2
		assertEquals '2', i.priId
	}
}
