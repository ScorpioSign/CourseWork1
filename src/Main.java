import java.util.Random;

public class Main {
    //**Базовая сложность**
    //   + 1. Создать класс Employee, который содержит информацию о Ф. И. О., отделе и зарплате сотрудника. Отделы для простоты должны быть названы от 1 до 5.
    //   + 2. Добавить статическую переменную-счетчик, которая будет отвечать за id.
    //    +3. Добавить в класс Employee поле id, которое проставляется из счетчика, а затем счетчик увеличивает свое значение.
    //    +4. Добавить возможность получать значения полей из Employee (геттеры) для всех полей.
    //    +5. Добавить возможность устанавливать значения полей отдела и зарплаты (сеттеры).
    //    +6. По умолчанию все поля должны передавать через конструктор (кроме id) и заполняться в нем (включая id, который нужно получить из счетчика).
    //    +7. Создать внутри класса с методом main поле типа Employee[10], которое будет выполнять роль «хранилища» для записей о сотрудниках.
    //    8. Создать статические методы, которые будут взаимодействовать с массивом и предоставлять результат:
    //      +  1. Получить список всех сотрудников со всеми имеющимися по ним данными (вывести в консоль значения всех полей (toString)).
    //       + 2. Посчитать сумму затрат на зарплаты в месяц.
    //        +3. Найти сотрудника с минимальной зарплатой.
    //        +4. Найти сотрудника с максимальной зарплатой.
    //        +5. Подсчитать среднее значение зарплат (можно использовать для этого метод из пункта b).
    //        +6. Получить Ф. И. О. всех сотрудников (вывести в консоль).
    public static void main(String[] args) {
        Random rnd = new Random();
        Employee[] employee = new Employee[10]; // создаем «хранилище» для записей о сотрудниках
        employee[0] = new Employee("Аникеева Анастасия Михайловна", rnd.nextInt(1, 6), rnd.nextInt(50000, 100000));
        employee[1] = new Employee("Подольская Арина Алексеевна", rnd.nextInt(1, 6), rnd.nextInt(50000, 100000));
        employee[2] = new Employee("Слесарев Андрей Сергеевич", rnd.nextInt(1, 6), rnd.nextInt(50000, 100000));
        employee[3] = new Employee("Киселева Виктория Дмитриевна", rnd.nextInt(1, 6), rnd.nextInt(50000, 100000));
        employee[4] = new Employee("Ведутенко Елена Анатольевна", rnd.nextInt(1, 6), rnd.nextInt(50000, 100000));
        employee[5] = new Employee("Гасанова Татьяна Вячеславовна", rnd.nextInt(1, 6), rnd.nextInt(50000, 100000));
        employee[6] = new Employee("Бондарев Михаил Сергеевич", rnd.nextInt(1, 6), rnd.nextInt(50000, 100000));
        employee[7] = new Employee("Ковылин Игорь Юрьевич", rnd.nextInt(1, 6), rnd.nextInt(50000, 100000));
        employee[8] = new Employee("Шарова Наталья Михайловна", rnd.nextInt(1, 6), rnd.nextInt(50000, 100000));
        employee[9] = new Employee("Ряжская Мария Владимировна", rnd.nextInt(1, 6), rnd.nextInt(50000, 100000));

        printInfo(employee); // Получаем список всех сотрудников со всеми имеющимися по ним данными
        System.out.printf("Сумма затрат на зарплаты в месяц %d руб.", MonthSalary(employee)); // Посчитали сумму затрат на зарплаты в месяц
        System.out.println();
        printMaxSalary(employee); //Нашли сотрудника с максимальной зарплатой
        System.out.println();
        printMinSalary(employee); // Нашли сотрудника с минимальной зарплатой
        System.out.println();
        printAverageSalary(employee); // Подсчитали среднее значение зарплат
        System.out.println();
        printNames(employee); // Вывели в консоль Ф. И. О. всех сотрудников

    }
    public static void printInfo(Employee[] employee) {
        for (int i = 0; i < employee.length; i++) {
            System.out.println(employee[i]);
        }

    }

    public static int MonthSalary(Employee[] employee) {
        int sum = 0;
        for (int i = 0; i < employee.length; i++) {
            sum = sum + employee[i].getSalary();
        }

        return sum;
    }


    public static void printMaxSalary(Employee[] employee) {
        int maxSalary = employee[0].getSalary();
        int index = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getSalary() > maxSalary) {
                maxSalary = employee[i].getSalary();
                index = i; // запоминаем индекс сотрудника с максимальной зарплатой
            }
        }
        System.out.printf("Сотрудник с максимальной зарплатой %d руб. - %s", maxSalary, employee[index].getName());
    }

    public static void printMinSalary(Employee[] employee) {
        int minSalary = employee[0].getSalary();
        int index = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getSalary() < minSalary) {
                minSalary = employee[i].getSalary();
                index = i;
            }
        }
        System.out.printf("Сотрудник с минимальной зарплатой %d руб. - %s", minSalary, employee[index].getName());
    }

    public static void printAverageSalary(Employee[] employee) {
        System.out.println("Средняя зарплата сотрудников в месяц составляет: " + MonthSalary(employee) / employee.length + "руб.");
    }

    public static void printNames(Employee[] employee) {
        System.out.println("Ф.И.О. сотрудников: ");
        for (int i = 0; i < employee.length; i++) {
            System.out.println(employee[i].getName());
        }
    }
}