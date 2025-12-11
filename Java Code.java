import java.util.*;

// ============ RESIDENT CLASS ============
class Resident {
    int residentID;
    String name;
    String email;
    String password;

    List<Problem> reportedProblems = new ArrayList<>();
    List<Feedback> givenFeedbacks = new ArrayList<>();

    List<String> viewCityNews() {
        System.out.println("Resident is viewing city news...");
        return new ArrayList<>();
    }

    Problem reportProblem(String description, String location, String photo) {
        System.out.println("Resident is reporting a problem: " + description);
        Problem p = new Problem(residentID, description, location, photo, "Pending");
        reportedProblems.add(p);
        return p;
    }

    List<Product> searchItems(String keyword) {
        System.out.println("Resident is searching for items: " + keyword);
        return new ArrayList<>();
    }

    Feedback giveFeedback(String comment, int rating) {
        System.out.println("Resident is giving feedback: " + comment);
        Feedback f = new Feedback(residentID, comment, rating, "", new Date());
        givenFeedbacks.add(f);
        return f;
    }

    List<String> getSuggestions(String category) {
        System.out.println("Resident is getting suggestions for: " + category);
        return new ArrayList<>();
    }

    boolean login(String email, String password) {
        System.out.println("Resident login attempt: " + email);
        return this.email.equals(email) && this.password.equals(password);
    }
}

// ============ PROBLEM CLASS ============
class Problem {
    int reportID;
    String description;
    String location;
    String photo;
    String status;

    Resident reporter;

    public Problem(int reporterID, String desc, String loc, String photo, String status) {
        this.reportID = (int)(Math.random() * 1000);
        this.description = desc;
        this.location = loc;
        this.photo = photo;
        this.status = status;
    }

    boolean submitReport() {
        System.out.println("Submitting problem report ID: " + reportID);
        return true;
    }

    void updateStatus(String newStatus) {
        System.out.println("Updating problem status to: " + newStatus);
        this.status = newStatus;
    }
}

// ============ FEEDBACK CLASS ============
class Feedback {
    int feedbackID;
    String comment;
    int rating;
    String reply;
    Date date;

    Resident feedbackGiver;

    public Feedback(int giverID, String comment, int rating, String reply, Date date) {
        this.feedbackID = (int)(Math.random() * 1000);
        this.comment = comment;
        this.rating = rating;
        this.reply = reply;
        this.date = date;
    }

    boolean submitFeedback() {
        System.out.println("Submitting feedback ID: " + feedbackID);
        return true;
    }

    void addReply(String replyText) {
        System.out.println("Adding reply: " + replyText);
        this.reply = replyText;
    }
}

// ============ PRODUCT CLASS ============
class Product {
    int productID;
    String name;
    double price;
    String description;
    boolean availability;

    Business business;

    void updatePrice(double newPrice) {
        System.out.println("Updating product price to: " + newPrice);
        this.price = newPrice;
    }

    void changeAvailability() {
        this.availability = !this.availability;
        System.out.println("Product availability changed to: " + availability);
    }
}

// ============ BUSINESS CLASS ============
class Business {
    int businessID;
    String name;
    String address;
    String description;
    String status;

    List<Product> products = new ArrayList<>();

    boolean approve() {
        System.out.println("Business approved: " + name);
        this.status = "Approved";
        return true;
    }

    void updateInfo(String newName, String newAddress) {
        System.out.println("Updating business info...");
        this.name = newName;
        this.address = newAddress;
    }
}

// ============ BUSINESS OWNER CLASS ============
class BusinessOwner {
    int ownerID;
    String name;
    String email;
    String password;
    String address;

    List<Business> businesses = new ArrayList<>();
    List<Product> products = new ArrayList<>();

    Business addBusiness(String name, String address) {
        System.out.println("Adding new business: " + name);
        Business b = new Business();
        b.name = name;
        b.address = address;
        businesses.add(b);
        return b;
    }

    Product addProduct(String name, double price) {
        System.out.println("Adding new product: " + name);
        Product p = new Product();
        p.name = name;
        p.price = price;
        products.add(p);
        return p;
    }

    void respondFeedback(int feedbackID, String response) {
        System.out.println("Responding to feedback ID: " + feedbackID);
    }

    Report viewPerformance() {
        System.out.println("Viewing performance report...");
        return new Report();
    }
}

// ============ ADMIN CLASS ============
class Admin {
    int adminID;
    String name;
    String email;
    String password;

    List<Problem> problemsToReview = new ArrayList<>();

    Problem reviewReport(int reportID) {
        System.out.println("Reviewing report ID: " + reportID);
        return new Problem(0, "", "", "", "");
    }

    void manageRecords() {
        System.out.println("Managing system records...");
    }

    void manageInformation() {
        System.out.println("Managing system information...");
    }

    SystemReport createReport(String reportType, Date startDate, Date endDate) {
        System.out.println("Creating system report: " + reportType);
        return new SystemReport(reportType, startDate, endDate);
    }

    boolean manageUser(String userType, int userID) {
        System.out.println("Managing user: " + userType + ", ID: " + userID);
        return true;
    }

    void keepRecords() {
        System.out.println("Keeping system records...");
    }
}

// ============ SYSTEM REPORT CLASS ============
class SystemReport {
    String reportType;
    Date startDate;
    Date endDate;
    String content;

    public SystemReport(String type, Date start, Date end) {
        this.reportType = type;
        this.startDate = start;
        this.endDate = end;
        this.content = "Report content for " + type;
    }

    void generateReport() {
        System.out.println("Generating system report: " + reportType);
    }

    boolean saveReport(String fileName) {
        System.out.println("Saving system report as: " + fileName);
        return true;
    }
}

class Report {
    String content = "Performance Report";
}

// ============ MAIN CLASS ============
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("=== SMART CITY SYSTEM ===");

        do {
            System.out.println("\nSelect your role:");
            System.out.println("1. Resident");
            System.out.println("2. Business Owner");
            System.out.println("3. Admin");
            System.out.println("0. Exit");
            System.out.print("Enter: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            switch(choice) {
                case 1: // Resident
                    Resident resident = new Resident();
                    resident.name = "Ali";
                    resident.email = "ali@city.com";
                    resident.password = "1234";

                    int rChoice;
                    do {
                        System.out.println("\n--- Resident Menu ---");
                        System.out.println("1. View City News");
                        System.out.println("2. Report Problem");
                        System.out.println("3. Search Items");
                        System.out.println("4. Give Feedback");
                        System.out.println("5. Get Suggestions");
                        System.out.println("0. Back");
                        System.out.print("Enter: ");
                        rChoice = sc.nextInt();
                        sc.nextLine();

                        switch(rChoice) {
                            case 1: resident.viewCityNews(); break;
                            case 2:
                                System.out.print("Enter problem description: ");
                                String desc = sc.nextLine();
                                System.out.print("Enter location: ");
                                String loc = sc.nextLine();
                                resident.reportProblem(desc, loc, "photo.jpg"); 
                                break;
                            case 3:
                                System.out.print("Enter search keyword: ");
                                String key = sc.nextLine();
                                resident.searchItems(key);
                                break;
                            case 4:
                                System.out.print("Enter feedback comment: ");
                                String comment = sc.nextLine();
                                System.out.print("Enter rating (1-5): ");
                                int rating = sc.nextInt();
                                sc.nextLine();
                                resident.giveFeedback(comment, rating);
                                break;
                            case 5:
                                System.out.print("Enter category: ");
                                String cat = sc.nextLine();
                                resident.getSuggestions(cat);
                                break;
                        }
                    } while(rChoice != 0);
                    break;

                case 2: // Business Owner
                    BusinessOwner owner = new BusinessOwner();
                    int bChoice;
                    do {
                        System.out.println("\n--- Business Owner Menu ---");
                        System.out.println("1. View Performance");
                        System.out.println("2. Respond Feedback");
                        System.out.println("3. Add Business");
                        System.out.println("4. Add Product");
                        System.out.println("0. Back");
                        System.out.print("Enter: ");
                        bChoice = sc.nextInt();
                        sc.nextLine();

                        switch(bChoice) {
                            case 1: owner.viewPerformance(); break;
                            case 2:
                                System.out.print("Enter feedback ID: ");
                                int fid = sc.nextInt();
                                sc.nextLine();
                                System.out.print("Enter response: ");
                                String resp = sc.nextLine();
                                owner.respondFeedback(fid, resp);
                                break;
                            case 3:
                                System.out.print("Enter business name: ");
                                String bName = sc.nextLine();
                                System.out.print("Enter address: ");
                                String bAddr = sc.nextLine();
                                owner.addBusiness(bName, bAddr);
                                break;
                            case 4:
                                System.out.print("Enter product name: ");
                                String pName = sc.nextLine();
                                System.out.print("Enter price: ");
                                double price = sc.nextDouble();
                                sc.nextLine();
                                owner.addProduct(pName, price);
                                break;
                        }
                    } while(bChoice != 0);
                    break;

                case 3: // Admin
                    Admin admin = new Admin();
                    int aChoice;
                    do {
                        System.out.println("\n--- Admin Menu ---");
                        System.out.println("1. Manage Records");
                        System.out.println("2. Manage Information");
                        System.out.println("3. Create System Reports");
                        System.out.println("4. Keep Records");
                        System.out.println("5. Review Reports");
                        System.out.println("0. Back");
                        System.out.print("Enter: ");
                        aChoice = sc.nextInt();
                        sc.nextLine();

                        switch(aChoice) {
                            case 1: admin.manageRecords(); break;
                            case 2: admin.manageInformation(); break;
                            case 3:
                                System.out.print("Enter report type: ");
                                String type = sc.nextLine();
                                admin.createReport(type, new Date(), new Date());
                                break;
                            case 4: admin.keepRecords(); break;
                            case 5:
                                System.out.print("Enter report ID: ");
                                int rid = sc.nextInt();
                                sc.nextLine();
                                admin.reviewReport(rid);
                                break;
                        }
                    } while(aChoice != 0);
                    break;

                case 0:
                    System.out.println("System shutting down...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while(choice != 0);

        sc.close();
    }
}
