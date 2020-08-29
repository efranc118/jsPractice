package main;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class AddressBook {
    private class User {

        private final String firstName;
        private final String lastName;

        public User(final String firstName, final String lastName) {

            this.firstName = firstName;
            this.lastName = lastName;
        }

        @Override
        public String toString() {
            final StringBuilder builder = new StringBuilder().append(firstName).append(" ").append(lastName);
            return builder.toString();
        }

    }

    private class Address {
        private final String city;
        private final String state;
        private final String country;

        public Address(final String city, final String state, final String country) {
            this.city = city;
            this.state = state;
            this.country = country;
        }

        public String getCity() {
            return this.city;
        }

        public String getState() {
            return this.state;
        }

        public String getCountry() {
            return this.country;
        }
    }

    private class AddressString {
        private final String value;

        public AddressString(final String val) {
            this.value = val;
        }

        public String getValue() {
            return this.value;
        }
    }

    private class StatsThread extends Thread {
        private final AddressBook addressBook;

        public StatsThread(final AddressBook ab) {
            this.addressBook = ab;
        }

        public void run() {
            this.addressBook.collectStats();
        }
    }

    private final Map<User, Address> addressMap = new HashMap<User, Address>();
    private final Map<String, Integer> addressStats = new HashMap<String, Integer>();
    private final ArrayList<AddressString> statsQueue = new ArrayList<AddressString>();
    private int statsIndex;
    private StatsThread st;

    public AddressBook() {
        this.statsIndex = 0;
        this.st = new StatsThread(this);
        this.st.start();
    }

    public void collectStats() {
        while (true) {
            synchronized (this.statsQueue) {
                if (this.statsIndex < this.statsQueue.size()) {
                    final AddressString element = this.statsQueue.get(this.statsIndex);
                    synchronized (this.addressStats) {
                        if (this.addressStats.containsKey(element.getValue())) {
                            this.addressStats.put(element.getValue(), this.addressStats.get(element.getValue()) + 1);
                        } else {
                            this.addressStats.put(element.getValue(), 1);
                        }
                        this.statsIndex = this.statsIndex + 1;
                    }
                }
            }
        }
    }

    public void addEntry(final User user, final Address address) {
        synchronized (this.statsQueue) {
            synchronized (this.addressStats) {
            if (this.addressStats.containsKey(address.getCity())) {
                int cityCount = this.addressStats.get(address.getCity());
                if (cityCount % 100 == 0) {
                    System.out.println("Over " + cityCount + " addresses in " + address.getCity() + "!");
                }
            }
            this.addressMap.put(user, address);
            this.statsQueue.add(new AddressString(address.getCity()));
            this.statsQueue.add(new AddressString(address.getState()));
            this.statsQueue.add(new AddressString(address.getCountry()));
            }
        }
    }

    public void addAddresses() {
        final Scanner reader = new Scanner(System.in);
        int toAdd = 1;
        for (int counter = 0;; ++counter) {
            final User user = new User("fName" + counter, "lName" + counter);
            final Address address = new Address("San Francisco", "CA", "USA");
            this.addEntry(user, address);
            System.out.println("added: " + user);
            toAdd--;
            if (toAdd <= 0) {
                System.out.print("How Many More to Add?");
                toAdd = reader.nextInt();
            }
            if (toAdd <= 0) {
                break;
            }
        }
        reader.close();
    }

    public static void main(final String args[]) {
        new AddressBook().addAddresses();
    }
}
