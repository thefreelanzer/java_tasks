package NestedRecord;

public record Employee(String id, String name, Address address, SalaryDetails salaryDetails) {

    record Address(String street, String city, String state, String zipCode) {
    }

    record SalaryDetails(double basicSalary, double allowances, double deductions) {
        /**
         * Method to calculate net salary
         *
         * @return salary
         */
        public double findNetSalary() {
            return basicSalary + allowances - deductions;
        }
    }

    void displayEmployeeInfo() {
        String addressLine = address.street + " " + address.city + " " + address.state + " " + address.zipCode;
        System.out.println("Id: " + id);
        System.out.println("Name: " + name);
        System.out.println("Address: " + addressLine);
        System.out.println("Net Salary: " + salaryDetails.findNetSalary());
        System.out.println("\n");
    }
}
