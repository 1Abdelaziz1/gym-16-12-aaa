import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
//gym and admin
public class Gym {
    // Attributes
    private String name;
    private String address;
    private String phoneNumber;
    public static List<Equipment> sportsEquipments = new ArrayList<>();
    public static List<Coach> coaches = new ArrayList<>(); // Initialize the list
    public static List<Customer> customers = new ArrayList<>();
    public static List<Subscription> subscriptions = new ArrayList<>();


    public Gym(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public static List<Equipment> getSportsEquipments() {
        return sportsEquipments;
    }

    public static void setSportsEquipments(List<Equipment> sportsEquipments) {
        Gym.sportsEquipments = sportsEquipments;
    }

    public static List<Coach> getCoaches() {
        return coaches;
    }

    public static void setCoaches(List<Coach> coaches) {
        Gym.coaches = coaches;
    }

    public static List<Customer> getCustomers() {
        return customers;
    }

    public static void setCustomers(List<Customer> customers) {
        Gym.customers = customers;
    }

    public static List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public static void setSubscriptions(List<Subscription> subscriptions) {
        Gym.subscriptions = subscriptions;
    }

    
    public static void displayCustomersOfCoach(int coachId) {
        try {
            System.out.println("Customers of Coach with ID " + coachId + ":");
            boolean coachFound = false;
            for (Coach coach : coaches) {
                if (coach.getId() == coachId) {
                    coachFound = true;
                    for (Customer customer : customers) {
                        if (customer.getSubscription().getAssignedCoachId() == coachId) {
                            System.out.println("Customer ID: " + customer.getId());
                            System.out.println("Customer Name: " + customer.getName());
                            System.out.println("Customer Phone Number: " + customer.getPhoneNumber());
                            System.out.println(); // Add a line break for better readability
                        }
                    }
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void addCustomer(Customer newCustomer){
        customers.add(newCustomer);
    }
    public void addCoach(Coach newCoach){
        coaches.add(newCoach);
    }
    public void addEquipment(Equipment newEquipment){
        sportsEquipments.add(newEquipment);
    }
    public void deleteCustomer(int customerID) {
        try {
            int index = -1;
            for (int i = 0; i < customers.size(); i++) {
                if (customers.get(i).getId() == customerID) {
                    index = i;
                }
            }
            if (index != -1) {
                customers.remove(index);
                System.out.println("Customer with ID " + customerID + " deleted successfully.");
            } else {
                throw new IllegalArgumentException("Customer not found with ID: " + customerID);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public void deleteCoach(int coachID) {
        try {
            int index = -1;
            for (int i = 0; i < coaches.size(); i++) {
                if (coaches.get(i).getId() == coachID) {
                    index = i;
                }
            }
            if (index != -1) {
                coaches.remove(index);
                System.out.println("Coach with ID " + coachID + " deleted successfully.");
            } else {
                throw new IllegalArgumentException("Coach not found with ID: " + coachID);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public void deleteEquipment(int equipmentCode) {
        try {
            int index = -1;
            for (int i = 0; i < sportsEquipments.size(); i++) {
                if (sportsEquipments.get(i).getEquipmentCode() == equipmentCode) {
                    index = i;
                }
            }
            if (index != -1) {
                sportsEquipments.remove(index);
                System.out.println("Equipment with Code " + equipmentCode + " deleted successfully.");
            } else {
                throw new IllegalArgumentException("Equipment not found with Code: " + equipmentCode);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void displayIncomeInMonth(int month, int year) {
        try {
            System.out.println("GYM Income for " + month + " " + year + ":");

            double totalIncome = 0.0;

            for (Subscription subscription : subscriptions) {
                LocalDate startDate = subscription.getMembershipPlan().getStartDate();
                int monthValue = startDate.getMonthValue();
                int yearValue = startDate.getYear();
                // Check if the subscription falls within the specified month and year
                if (monthValue == month && yearValue == year) {
                    // Calculate the income for the subscription
                    double subscriptionIncome = subscription.getMembershipPlan().getPrice();
                    totalIncome += subscriptionIncome;
                }
            }

            System.out.println("Total Income: " + totalIncome);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


}