public class EmployeeBook {
    private final Employee[] employee = new Employee[10];

    public void printInfo() {
        for (int i = 0; i < employee.length; i++) {
            System.out.println(employee[i]);
        }

    }

    public void indexSalary(double percent) {
        System.out.printf("Зарплата сотрудников после индексации на %.0f процентов\n", percent);

        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null) {
                employee[i].setSalary(Math.round(employee[i].getSalary() * (1 + percent / 100)));
            }
        }
        printInfo();
    }


    public void findDepartmentMinSalary(int departmentNumber) {
        double minDepartmentSalary = 200000;
        int index = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null && employee[i].getDepartment() == departmentNumber && employee[i].getSalary() < minDepartmentSalary) {
                minDepartmentSalary = employee[i].getSalary();
                index = i;
            }
        }

        System.out.printf("Сотрудник с минимальной зарплатой в %d отделе %.0f руб. - %s", departmentNumber, minDepartmentSalary, employee[index].getName());


    }

    public void findDepartmentMaxSalary(int departmentNumber) {
        double maxDepartmentSalary = 0;
        int index = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null && employee[i].getDepartment() == departmentNumber && employee[i].getSalary() > maxDepartmentSalary) {
                maxDepartmentSalary = employee[i].getSalary();
                index = i;
            }
        }

        System.out.printf("Сотрудник с максимальной зарплатой в %d отделе %.0f руб. - %s", departmentNumber, maxDepartmentSalary, employee[index].getName());


    }

    public void findDepartmentTotalSalary(int departmentNumber) {
        double sumDepartmentSalary = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null && employee[i].getDepartment() == departmentNumber) {
                sumDepartmentSalary = sumDepartmentSalary + employee[i].getSalary();
            }
        }
        System.out.printf("Сумма затрат на зарплату по отделу %.0f руб. в месяц",sumDepartmentSalary);
    }

    public void findDepartmentAverageSalary(int departmentNumber) {
        double sumDepartmentSalary = 0;
        int index = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null && employee[i].getDepartment() == departmentNumber) {
                sumDepartmentSalary = sumDepartmentSalary + employee[i].getSalary();
                index++;  // считаем количество сотрудников в отделе
            }

        }
        System.out.print("Средняя зарплата по отделу №" + departmentNumber +  " составляет " + sumDepartmentSalary / index);
    }

    public void indexDepartmentSalary(int departmentNumber, double percent) {
        System.out.printf("Зарплата сотрудников %d отдела после индексации на %.0f процентов\n", departmentNumber, percent);
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null && employee[i].getDepartment() == departmentNumber) {
                employee[i].setSalary(employee[i].getSalary() * (1 + percent / 100));
                System.out.println(employee[i]);

            }
        }

    }

    public void printEmployeesOfDepartment(int departmentNumber) {
        System.out.printf("Список сотрудников %d отдела:\n", departmentNumber);
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null && employee[i].getDepartment() == departmentNumber) {
                System.out.println("ID " + employee[i].getId() + " Ф.И.О " + employee[i].getName() + " ; зарплата: " + employee[i].getSalary());

            }
        }
    }

    public void findEmployeeLowSalary(int number) {
        System.out.printf("Список сотрудников с зарплатой ниже %d руб.:\n", number);
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null && employee[i].getSalary() < number) {
                System.out.println(employee[i]);

            }
        }
    }

    public void findEmployeeHighSalary( int number) {
        System.out.printf("Список сотрудников с зарплатой выше %d руб.:\n", number);
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null && employee[i].getSalary() >= number) {
                System.out.println(employee[i]);
            }
        }
    }

    private int findFreeIndex() {
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public void addEmployee(String fio, int dep, int sal) {
        int index = findFreeIndex();
        if (index == -1) {
            System.out.println("Хранилище заполнено. Добавление нового сотудника невозможно");
        } else {
            employee[index] = new Employee(fio, dep, sal);
        }

    }

    public void removeEmployee(String fio) {
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null && employee[i].getName().equals(fio)) {
                employee[i] = null;
            }
        }

    }

    public void removeEmployee(int ind) {
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null && employee[i].getId() == ind) {
                employee[i] = null;
            }
        }


    }
    public void changeSalary(String fio, int sal){
        for (int i = 0; i < employee.length; i++) {
            if(employee[i] != null && employee[i].getName().equals(fio)){
                employee[i].setSalary(sal);
            }
        }
    }
    public void changeDepartment(String fio, int dep){
        for (int i = 0; i < employee.length; i++) {
            if(employee[i] != null && employee[i].getName().equals(fio)){
                employee[i].setDepartment(dep);
            }
        }
    }
    public void printDepartment(){
        System.out.println("Список сотрудников по отделам: ");
        for (int j = 1; j <= 5; j++) {
            System.out.println("Отдел " + j + ":");
            for (int i = 0; i < employee.length; i++) {
                if (employee[i] != null && employee[i].getDepartment() == j){
                    System.out.println( employee[i].getId() + " " + employee[i].getName());

                }

            }
        }
    }
}
