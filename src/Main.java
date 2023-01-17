import java.util.Random;

public class Main {
    //- **Повышенная сложность**
    //    Создать дополнительные статические методы для решения следующих задач.

    //    1. Проиндексировать зарплату (вызвать изменение зарплат у всех сотрудников на величину аргумента в %).
    //    2. Получить в качестве параметра номер отдела (1–5) и найти (всего 6 методов):
    //        +1. Сотрудника с минимальной зарплатой.
    //        +2. Сотрудника с максимальной зарплатой.
    //        +3. Сумму затрат на зарплату по отделу.
    //        +4. Среднюю зарплату по отделу (учесть, что количество людей в отделе отличается от employees.length).
    //        +5. Проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра.
    //        +6. Напечатать всех сотрудников отдела (все данные, кроме отдела).
    //    3. Получить в качестве параметра число и найти:
    //        1. Всех сотрудников с зарплатой меньше числа (вывести id, Ф. И. О. и зарплатой в консоль).
    //        2. Всех сотрудников с зарплатой больше (или равно) числа (вывести id, Ф. И. О. и зарплатой в консоль).
    public static void main(String[] args) {
        Random rnd = new Random();
        Employee[] employee = new Employee[10];
        employee[0] = new Employee("Аникеева Анастасия Михайловна", 1, rnd.nextInt(50000, 100000));
        employee[1] = new Employee("Подольская Арина Алексеевна", 2, rnd.nextInt(50000, 100000));
        employee[2] = new Employee("Слесарев Андрей Сергеевич", 3, rnd.nextInt(50000, 100000));
        employee[3] = new Employee("Киселева Виктория Дмитриевна", 4, rnd.nextInt(50000, 100000));
        employee[4] = new Employee("Ведутенко Елена Анатольевна", 5, rnd.nextInt(50000, 100000));
        employee[5] = new Employee("Гасанова Татьяна Вячеславовна", 1, rnd.nextInt(50000, 100000));
        employee[6] = new Employee("Бондарев Михаил Сергеевич", 2, rnd.nextInt(50000, 100000));
        employee[7] = new Employee("Ковылин Игорь Юрьевич", 2, rnd.nextInt(50000, 100000));
        employee[8] = new Employee("Шарова Наталья Михайловна", 4, rnd.nextInt(50000, 100000));
        employee[9] = new Employee("Ряжская Мария Владимировна", 5, rnd.nextInt(50000, 100000));

        printInfo(employee); // Получаем список всех сотрудников со всеми имеющимися по ним данными
        System.out.println();
        indexSalary(employee,10);//Индексируем зарплату всем сотрудникам на 10% (п.1)
        System.out.println();
        findDepartmentMinSalary(employee, 2); // находим сотрудника с мин. зарплатой в отделе
        System.out.println();
        findDepartmentMaxSalary(employee, 2);  // находим сотрудника с макс. зарплатой в отделе
        System.out.println();
        findDepartmentTotalSalary(employee, 2); // находим сумму затрат на зарплату по отделу
        System.out.println();
        findDepartmentAverageSalary(employee, 2); // находим среднюю зарплату в отделе
        System.out.println();
        indexDepartmentSalary(employee, 2,7); // индексируем зарплату сотрудникам отдела на 7%
        System.out.println();
        printEmployeesOfDepartment(employee,2);  //печатаем список сотрудников отдела (все данные, кроме номера отдела)
        System.out.println();
        findEmployeeLowSalary(employee, 70000);   //печатаем список сотрудников отдела с зарплатой ниже 70 000 (все данные, кроме номера отдела)
        System.out.println();
        findEmployeeHighSalary (employee, 70000);  //печатаем список сотрудников отдела с зарплатой выше 70 000 (все данные, кроме номера отдела)

    }
    public static void printInfo(Employee[] employee) {
        System.out.println("Общий список сотрудников: ");
        for (int i = 0; i < employee.length; i++) {
            System.out.println(employee[i]);
        }

    }

    public static void indexSalary(Employee[] employee, double percent){
        System.out.printf("Зарплата сотрудников после индексации на %.0f процентов\n", percent);
        for (int i = 0; i < employee.length; i++) {
            employee[i].setSalary(Math.round(employee[i].getSalary() *(1 + percent/100)));
        }
        printInfo(employee);
    }



    public static void findDepartmentMinSalary(Employee[] employee, int departmentNumber) {
        double minDepartmentSalary = 200000;
        int index = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getDepartment() == departmentNumber && employee[i].getSalary() < minDepartmentSalary) {
                minDepartmentSalary = employee[i].getSalary();
                index = i;
            }
        }

        System.out.printf("Сотрудник с минимальной зарплатой в %d отделе %.0f руб. - %s", departmentNumber, minDepartmentSalary, employee[index].getName());


    }

    public static void findDepartmentMaxSalary(Employee[] employee, int departmentNumber) {
        double maxDepartmentSalary = 0;
        int index = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getDepartment() == departmentNumber && employee[i].getSalary() > maxDepartmentSalary) {
                maxDepartmentSalary = employee[i].getSalary();
                index = i;
            }
        }

        System.out.printf("Сотрудник с максимальной зарплатой в %d отделе %.0f руб. - %s", departmentNumber, maxDepartmentSalary, employee[index].getName());


    }

    public static void findDepartmentTotalSalary(Employee[] employee, int departmentNumber) {
        double sumDepartmentSalary = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getDepartment() == departmentNumber) {
                sumDepartmentSalary = sumDepartmentSalary + employee[i].getSalary();
            }
        }
        System.out.printf("Сумма затрат на зарплату по отделу %.0f руб. в месяц", sumDepartmentSalary);
    }
    public static void findDepartmentAverageSalary(Employee[] employee, int departmentNumber) {
        double sumDepartmentSalary = 0;
        int index = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getDepartment() == departmentNumber) {
                sumDepartmentSalary = sumDepartmentSalary + employee[i].getSalary();
                index ++;  // считаем количество сотрудников в отделе
            }

        }
        System.out.printf("Средняя зарплата по отделу %.2f руб. в месяц", sumDepartmentSalary/index);
    }
    public static void indexDepartmentSalary(Employee[] employee, int departmentNumber, double percent){
        System.out.printf("Зарплата сотрудников %d отдела после индексации на %.0f процентов\n", departmentNumber, percent);
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getDepartment() == departmentNumber) {
                employee[i].setSalary(employee[i].getSalary()*(1+percent/100));
                System.out.println(employee[i]);

            }
        }

    }
    public static void printEmployeesOfDepartment(Employee[]employee, int departmentNumber) {
        System.out.printf("Список сотрудников %d отдела:\n", departmentNumber);
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getDepartment() == departmentNumber) {
                System.out.println("ID " + employee[i].getId() + " Ф.И.О " + employee[i].getName() + " ; зарплата: " + Math.round(employee[i].getSalary()));

            }
        }
    }
    public static void findEmployeeLowSalary(Employee[] employee, int number){
        System.out.printf("Список сотрудников с зарплатой ниже %d руб.:\n", number);
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getSalary() < number){
                System.out.println("ID " + employee[i].getId() + " Ф.И.О " + employee[i].getName() + " ; зарплата: " + Math.round(employee[i].getSalary()));
            }
        }
    }
    public static void findEmployeeHighSalary(Employee[] employee, int number){
        System.out.printf("Список сотрудников с зарплатой выше %d руб.:\n", number);
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getSalary() >= number){
                System.out.println("ID " + employee[i].getId() + " Ф.И.О " + employee[i].getName() + " ; зарплата: " + Math.round(employee[i].getSalary()));
            }
        }
    }

}