package hello;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToMany(mappedBy = "addressBook", cascade = CascadeType.PERSIST)
    private List<BuddyInfo> addressBook;

    public AddressBook() {
        this.addressBook = new ArrayList();
    }

    public void addToAddressBook(BuddyInfo b) {
        getAddressBook().add(b);
    }


    public List<BuddyInfo> getAddressBook() {
        return addressBook;
    }

    public void setAddressBook(List<BuddyInfo> addressBook) {
        this.addressBook = addressBook;
    }

    @Override
    public String toString() {
        String results = "";
        for(BuddyInfo b : getAddressBook()) {
            results += b.toString();
        }
        return results;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddressBook)) return false;
        AddressBook a = (AddressBook) o;
        return a.getAddressBook().equals(this.getAddressBook());
    }

    public static void main(String[] args) {
        BuddyInfo b1 = new BuddyInfo("Bhavik", "1234949452");
        BuddyInfo b2 = new BuddyInfo("Taz", "7584840303");
        BuddyInfo b3 = new BuddyInfo("Nisaa", "3030920011");
    }
}
