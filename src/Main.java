import java.util.Random;

public class Main {
    // Привести структуру проекта к ООП.
    //
    //1. +Создать класс EmployeeBook.
    //2. +Перенести хранилище сотрудников в него (массив), закрыть к нему доступ извне (сделать приватным).
    //3. Все статические методы по работе с массивом перенести в этот класс и сделать нестатическими.
    //4. Добавить несколько новых методов:
    //    1. Добавить нового сотрудника (создаем объект, заполняем поля, кладем в массив).
    //    Нужно найти свободную ячейку в массиве и добавить нового сотрудника в нее. Искать нужно всегда с начала, так как возможно добавление в ячейку удаленных ранее сотрудников.
    //    2. Удалить сотрудника (находим сотрудника по Ф. И. О. и/или id, обнуляем его ячейку в массиве).
    //5. Изменить сотрудника (получить сотрудника по Ф. И. О., модернизировать его запись):
    //    1. Изменить зарплату.
    //    2. Изменить отдел.
    //    Придумать архитектуру. Сделать или два метода, или один, но продумать его.

    public static void main(String[] args) {
        Random rnd = new Random();
        EmployeeBook employeeBook = new EmployeeBook();
        employeeBook.addEmployee("Аникеева Анастасия Михайловна", 1, rnd.nextInt(50000, 100000));
        employeeBook.addEmployee("Подольская Арина Алексеевна", 2, rnd.nextInt(50000, 100000));
        employeeBook.addEmployee("Слесарев Андрей Сергеевич", 3, rnd.nextInt(50000, 100000));
        employeeBook.addEmployee("Киселева Виктория Дмитриевна", 4, rnd.nextInt(50000, 100000));
        employeeBook.addEmployee("Ведутенко Елена Анатольевна", 5, rnd.nextInt(50000, 100000));
        employeeBook.addEmployee("Гасанова Татьяна Вячеславовна", 1, rnd.nextInt(50000, 100000));
        employeeBook.addEmployee("Ковылин Игорь Юрьевич", 2, rnd.nextInt(50000, 100000));
        employeeBook.addEmployee("Шарова Наталья Михайловна", 4, rnd.nextInt(50000, 100000));
        employeeBook.addEmployee("Ряжская Мария Владимировна", 5, rnd.nextInt(50000, 100000));


        employeeBook.printInfo();
        System.out.println();
        employeeBook.indexSalary(10);//Индексируем зарплату всем сотрудникам на 10%

        employeeBook.findDepartmentMinSalary(2);
        System.out.println();
        employeeBook.findDepartmentMaxSalary(2);
        System.out.println();
        employeeBook.findDepartmentTotalSalary(2);
        System.out.println();
        employeeBook.findDepartmentAverageSalary(2);
        System.out.println();
        employeeBook.indexDepartmentSalary(2, 7);
        System.out.println();
        employeeBook.printEmployeesOfDepartment(2);
        System.out.println();
        employeeBook.findEmployeeLowSalary(70000);
        System.out.println();
        employeeBook.findEmployeeHighSalary(70000);
        System.out.println();

        employeeBook.addEmployee("Бондарев Михаил Сергеевич", 2, rnd.nextInt(50000, 100000)); // добавили сотрудника
        employeeBook.removeEmployee("Ковылин Игорь Юрьевич"); // удалили сотрудника по ФИО
        employeeBook.removeEmployee(3);   // удалили сотрудника по ID
        employeeBook.changeSalary("Шарова Наталья Михайловна", 150000); // изменили зарплату сотудника
        employeeBook.changeDepartment("Шарова Наталья Михайловна", 3); //перевели сотрудника в другой отдел

        employeeBook.printInfo(); // печатаем список сотрудников после изменений
        employeeBook.printDepartment();
    }
}