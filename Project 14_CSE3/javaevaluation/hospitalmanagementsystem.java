import java.util.Scanner;

class Patient {
    private String name;
    private int age;
    private String gender;

    public Patient(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Gender: " + gender;
    }
}

class Appointment {
    private Patient patient;
    private String date;
    private String time;

    public Appointment(Patient patient, String date, String time) {
        this.patient = patient;
        this.date = date;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Patient: " + patient.getName() + ", Date: " + date + ", Time: " + time;
    }
}

public class hospitalmanagementsystem{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int maxAppointments = 100;
        Appointment[] appointments = new Appointment[maxAppointments];
        int appointmentCount = 0;

        while (true) {
            System.out.println("Hospital Management System");
            System.out.println("1. Schedule an appointment");
            System.out.println("2. View scheduled appointments");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    if (appointmentCount < maxAppointments) {
                        System.out.print("Enter patient name: ");
                        String patientName = scanner.nextLine();
                        System.out.print("Enter patient age: ");
                        int patientAge = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter patient gender: ");
                        String patientGender = scanner.nextLine();
                        System.out.print("Enter appointment date: ");
                        String appointmentDate = scanner.nextLine();
                        System.out.print("Enter appointment time: ");
                        String appointmentTime = scanner.nextLine();

                        Patient patient = new Patient(patientName, patientAge, patientGender);
                        Appointment appointment = new Appointment(patient, appointmentDate, appointmentTime);
                        appointments[appointmentCount] = appointment;
                        appointmentCount++;

                        System.out.println("Appointment scheduled successfully!");
                    } else {
                        System.out.println("Appointment slots are full.");
                    }
                    break;

                case 2:
                    System.out.println("Scheduled Appointments:");
                    for (int i = 0; i < appointmentCount; i++) {
                        System.out.println(appointments[i]);
                    }
                    break;

                case 3:
                    System.out.println("Exiting the system.");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}