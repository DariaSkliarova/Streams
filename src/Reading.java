import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Reading {

    public static void main(String[] args) {
        try {
            new Reading().begin();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void begin() throws Exception {

        Collection<Integer> nums1 = new ArrayList<>();
        try (Scanner scanner = new Scanner(
                new FileInputStream("text2.txt"), StandardCharsets.UTF_8)){
            int i = 0;
            while (scanner.hasNextInt() && i <= 100) {
                int n = scanner.nextInt();
                if (n > 0) {
                    nums1.add(n);
                }
                i++;
            }
        }


        Collection<Integer> nums2 = new ArrayList<>();
        try (Scanner scanner = new Scanner(
                new FileInputStream("text3.txt"), StandardCharsets.UTF_8.name()).useDelimiter("\\D*,\\D")) {
            int i = 0;
            while (scanner.hasNextInt() && i <= 100) {
                int n = scanner.nextInt();
                if (n > 0) {
                    nums2.add(n);
                }
                i++;
            }
        }

        System.out.println("Average from file \"text2.txt\" = " + findAverage(nums1) +
                "\nAverage from file \"text3.txt\" = " + findAverage(nums2));

        List<Contact> contacts = new ArrayList<>();
        Contact contact;

        try (Scanner scanner = new Scanner(new FileInputStream("Contacts.txt"),
                StandardCharsets.UTF_8)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] params = line.split("\\|");
                contact = settingParams(params);
                contacts.add(contact);
            }
        }

        System.out.println("\nSorted Contact Collection that was read from file \"Contacts.txt\"\n" +
                "Sorted by year of birth (ascending):\n");

        showSortedContacts(sortingContacts(contacts));
    }

    public int findAverage(Collection<Integer> nums) {
        int result;
        double midResult = 0;
        int n = 0;
        for (Integer num : nums) {
            midResult += num;
            n++;
        }
        result = (int) (midResult / n);
        return result;
    }

    public Contact settingParams(String[] params) {
        Contact contact = new Contact();
        contact.setName(params[0]);
        contact.setSurname(params[1]);
        contact.setTelNumber(params[2]);
        contact.setDate(params[3]);
        return contact;
    }

    public int findingYear(Contact contact) {
        String[] nums;
        nums = contact.getDate().split("\\.");
        int x = Integer.parseInt(nums[2]);
        return x;
    }

    public Collection<Contact> sortingContacts(List<Contact> contacts) {
        Comparator<Contact> comparator = new Comparator<Contact>() {
            @Override
            public int compare(Contact left, Contact right) {
                return findingYear(left) - findingYear(right);
            }
        };
        Collections.sort(contacts, comparator);
        return contacts;
    }

    public void showSortedContacts(Collection<Contact> contacts) {
        int i = 0;
        for (Contact contact : contacts) {
            if (i < 5) {
                System.out.println(contact.getDate() + " | " + contact.getName() + " | "
                        + contact.getSurname() + " | " + contact.getTelNumber());
                i++;
            }
        }
    }
}


