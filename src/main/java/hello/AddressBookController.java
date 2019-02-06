package hello;

import org.springframework.web.bind.annotation.*;

@RestController
public class AddressBookController {
    private AddressBook addressBook = null;

    @RequestMapping(value="/createaddressboook", method = RequestMethod.GET)
    public void createAddressBook() {
        this.addressBook = new AddressBook();
    }

    @RequestMapping(value = "/addbuddy", method = RequestMethod.POST)
    public void addBuddy(@RequestBody BuddyInfo buddy) {
        if (buddy != null) {
            addressBook.addToAddressBook(buddy);
        }
    }

/*    @RequestMapping(value = "/deletebuddy/{id}", method = RequestMethod.DELETE)
    public void removeBuddy(@PathVariable int id) {

    }*/

    @RequestMapping(value="/getbuddy", method = RequestMethod.GET)
    public BuddyInfo getAddressBook(@RequestParam("name") String name) {
        BuddyInfo retBuddy = null;
        for (BuddyInfo b: addressBook.getAddressBook()) {
            if (b.getName().equals(name)) retBuddy = b;
        }
        return retBuddy;
    }

}
