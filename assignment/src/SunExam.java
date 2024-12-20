import java.util.Scanner;

interface GradeCalculator{
    double calculateUndergraduate();
    double calculateGraduate();
    double calculatePhD();
}

class UndergraduateStudent implements GradeCalculator {
    double baseGrade;
    double attendance;
    boolean lateAssignments;

    public UndergraduateStudent() {
        this.baseGrade = baseGrade;
        this.attendance = attendance;
        this.lateAssignments = lateAssignments;
    }

    @Override
    public double calculateUndergraduate() {
        double finalGrade = baseGrade;
        if (attendance > 90) finalGrade += baseGrade * 0.05;
        if (lateAssignments) finalGrade -= baseGrade * 0.10;
        return Math.min(100, Math.max(50, finalGrade));
    }


    @Override
    public double calculateGraduate() {
        throw new UnsupportedOperationException("Not applicable for Graduate");
    }

    @Override
    public double calculatePhD() {
        throw new UnsupportedOperationException("Not applicable for PHD");
    }

    static class GraduateStudent implements GradeCalculator {
        double baseGrade;
        boolean publishedPaper;
        boolean missedDeadlines;

        public GraduateStudent() {
            this.baseGrade = baseGrade;
            this.publishedPaper = publishedPaper;
            this.missedDeadlines = missedDeadlines;
        }

        @Override
        public double calculateUndergraduate() {
            throw new UnsupportedOperationException("Not applicable for Undergraduate");
        }

        @Override
        public double calculateGraduate() {
            double finalGrade = baseGrade;
            if (publishedPaper) finalGrade += baseGrade * 0.10;
            if (missedDeadlines) finalGrade -= baseGrade * 0.05;
            return Math.min(100, Math.max(60, finalGrade));
        }

        @Override
        public double calculatePhD() {
            throw new UnsupportedOperationException("Not applicable for PHD");
        }

        static class PhDStudent implements GradeCalculator {
            double baseGrade;
            boolean taughtCourse;
            boolean incompleteResearch;

            public PhDStudent() {
                this.baseGrade = baseGrade;
                this.taughtCourse = taughtCourse;
                this.incompleteResearch = incompleteResearch;
            }

            @Override
            public double calculatePhD() {
                double finalGrade = baseGrade;
                if (taughtCourse) finalGrade += baseGrade * 0.08;
                if (incompleteResearch) finalGrade -= baseGrade * 0.15;
                return Math.min(100, Math.max(70, finalGrade));
            }

            @Override
            public double calculateUndergraduate() {
                throw new UnsupportedOperationException("Not applicable for PhDStudent");
            }

            @Override
            public double calculateGraduate() {
                throw new UnsupportedOperationException("Not applicable for PhDStudent");
            }
        }

        class Student {
            String firstName;
            String lastName;
            int studentID;
            int age;
            String dateOfBirth;
            String program;
            int yearOfStudy;
            double gpa;

            public Student(String firstName, String lastName, int studentID, int age, String dateOfBirth, String program, int yearOfStudy, double gpa) {
                this.firstName = firstName;
                this.lastName = lastName;
                this.studentID = studentID;
                this.age = age;
                this.dateOfBirth = dateOfBirth;
                this.program = program;
                this.yearOfStudy = yearOfStudy;
                this.gpa = gpa;
            }

            class InputValidator {
                public static boolean isValidFName(String fName) {
                    return fName.matches("[A-Za-z]+");
                }

                public static boolean isValidLName(String lName) {
                    return lName.matches("[A-Za-z]+");
                }

            }

            public static boolean isValidStudentId(String empId) {
                return empId.matches("\\d+");
            }

            public static boolean isValidAge(String age) {
                try {
                    int ageInt = Integer.parseInt(age);
                    return ageInt >= 18 && ageInt <= 70;
                } catch (NumberFormatException e) {
                    return false;
                }
            }

            public static boolean isValidDob(String dob) {
                return dob.matches("\\d{4}-\\d{2}-\\d{2}");
            }

            public static boolean isValidDepartment(String department) {
                return department.equals("Accounting") || department.equals("Planning") ||
                        department.equals("Strategy") || department.equals("Human Resources");
            }


            public static boolean isValidExperience(String years) {
                try {
                    int exp = Integer.parseInt(years);
                    return exp >= 1 && exp <= 10;
                } catch (NumberFormatException e) {
                    return false;
                }
            }
        }

        public class AucaGradingSystem {
            private static Student InputValidator;

            public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);

                System.out.println("--- Grading System ---");

                System.out.print("Enter First Name: ");
                String firstName;
                do {
                    firstName = scanner.next();
                    if (!Student.InputValidator.isValidFName(firstName)) {
                        System.out.println("Invalid name. Please enter letters only.");
                        System.out.print("Enter First Name: ");
                    }
                } while (!Student.InputValidator.isValidFName(firstName));


                System.out.print("Enter Last Name: ");
                String lastName;
                do {
                    lastName = scanner.next();
                    if (!Student.InputValidator.isValidLName(lastName)) {
                        System.out.println("Invalid name. Please enter letters only.");
                    }
                } while (!Student.InputValidator.isValidLName(lastName));


                String employeeId;
                do {
                    System.out.print("Enter the student ID : ");
                    employeeId = scanner.next();
                    if (!InputValidator.isValidStudentId(employeeId)) {
                        System.out.println("Invalid ID. Please enter numbers only.");
                    }
                } while (!InputValidator.isValidStudentId(employeeId));


                String age;
                do {
                    System.out.print("Enter Age : ");
                    age = scanner.next();
                    if (!InputValidator.isValidAge(age)) {
                        System.out.println("Invalid age .Please enter numbers only in a range of(18-70)");
                    }
                } while (!InputValidator.isValidAge(age));


                String dob;
                do {
                    System.out.print("Enter Date of Birth (yyyy-mm-dd): ");
                    dob = scanner.next();
                    if (!InputValidator.isValidDob(dob)) {
                        System.out.println("Invalid date of birth .Please enter numbers only in the format (yyyy-mm-dd):");
                    }
                } while (!InputValidator.isValidDob(dob));

                String department;
                do {
                    System.out.print("Enter Department (Accounting, Planning, Strategy, Human Resources): ");
                    department = scanner.next();
                } while (!InputValidator.isValidDepartment(department));

                String experience;
                do {
                    System.out.print("Enter Years of studying (minimum 1): ");
                    experience = scanner.next();
                } while (!InputValidator.isValidExperience(experience));
                System.out.println("Student Types:");
                System.out.println("1. Undergraduate");
                System.out.println("2. Graduate");
                System.out.println("3. PHD");
                String empType;
                do {
                    System.out.print("Select Employee Type (1/2/3): ");
                    empType = scanner.nextLine();
                } while (!empType.matches("[123]"));

                System.out.print("Enter the base grades: ");
                double baseGrade = scanner.nextDouble();
                GradeCalculator employee;

                double finalGrade = 0;
                switch (empType) {
                    case "1":
                        employee = new UndergraduateStudent();
                        finalGrade = employee.calculateUndergraduate();
                        break;
                    case "2":
                        employee = new GraduateStudent();
                        finalGrade = employee.calculateGraduate();
                        break;
                    case "3":
                        employee = new PhDStudent();
                        finalGrade = employee.calculatePhD();
                        break;
                }
                System.out.println("\n=== Student Details ===");
                System.out.println("Name: " + firstName + " " + lastName);
                System.out.println("Employee ID: " + employeeId);
                System.out.println("Age: " + age);
                System.out.println("Date of Birth: " + dob);
                System.out.println("Department: " + department);
                System.out.println("Years of Experience: " + experience);
                System.out.printf("Final Salary after deductions: %.2f\n", finalGrade);
                System.out.println("=======================");

                scanner.close();

            }
        }
    }
}
