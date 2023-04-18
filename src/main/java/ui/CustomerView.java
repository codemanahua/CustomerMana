package ui;

import Util.CMUtility;
import bean.Customer;
import service.CustomerList;

public class CustomerView {
    private CustomerList customerList = new CustomerList(10);

    public CustomerView() {
        Customer customer = new Customer("花花", '男', 25, "123112434", "njhbd@gmail.com");
        customerList.addCustomer(customer);
    }

    // 进入页面
    public void enterMainMenu() {
        boolean isFlag = true;
        while (isFlag) {
            System.out.println("——————————客户管理系统——————————");
            System.out.println("            1，添加用户");
            System.out.println("            2，修改用户");
            System.out.println("            3，删除用户");
            System.out.println("            4，客户列表");
            System.out.println("            5，退出");
            System.out.print("           请选择(1-5):");

            char menu = CMUtility.readMenuSelection();
            switch (menu) {
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomer();
                    break;
                case '5':
                    System.out.println("确定是否退出（Y/N）：");
                    char isExit = CMUtility.readConfirmSelection();
                    if (isExit == 'Y') {
                        isFlag = false;
                    }
            }
        }
    }

    // 添加客户
    public void addNewCustomer() {
        // System.out.println("添加");
        System.out.println("——————————添加客户——————————");
        System.out.println("姓名：");
        String name = CMUtility.readString(10);
        System.out.println("性别：");
        char gender = CMUtility.readChar();
        System.out.println("年龄：");
        int age = CMUtility.readInt();
        System.out.println("电话：");
        String phone = CMUtility.readString(13);
        System.out.println("邮箱：");
        String email = CMUtility.readString(30);

        Customer customer = new Customer(name, gender, age, phone, email);
        boolean isSuccess = customerList.addCustomer(customer);
        if (isSuccess) {
            System.out.println("——————————添加完成——————————");
        } else {
            System.out.println("——————————添加客户已满，添加失败——————————");
        }
    }

    // 修改客户
    public void modifyCustomer() {
        //  System.out.println("修改");
        System.out.println("——————————修改客户——————————");
        Customer customer;
        int number;
        for (; ; ) {
            System.out.println("请选择修改的客户编号(-1退出)");
            number = CMUtility.readInt();
            if (number == -1) {
                return;
            }
            customer = customerList.getCustomerByIndex(number - 1);
            if (customer == null) {
                System.out.println("无法找到指定客户！");
            } else {
                break;
            }
        }
        // 修改客户信息
        System.out.println("姓名(" + customer.getName() + "):");
        String name = CMUtility.readString(10, customer.getName());
        System.out.println("性别(" + customer.getGender() + "):");
        char gender = CMUtility.readChar(customer.getGender());
        System.out.println("年龄(" + customer.getAge() + "):");
        int age = CMUtility.readInt(customer.getAge());
        System.out.println("电话(" + customer.getPhone() + "):");
        String phone = CMUtility.readString(13, customer.getPhone());
        System.out.println("邮箱(" + customer.getEmail() + "):");
        String email = CMUtility.readString(30, customer.getEmail());

        Customer newCust = new Customer(name, gender, age, phone, email);
        boolean isReplaced = customerList.replaceCustomer(number - 1, newCust);
        if (isReplaced) {
            System.out.println("——————————修改成功——————————");
        } else {
            System.out.println("——————————修改失败——————————");
        }
    }

    // 删除客户
    public void deleteCustomer() {
//        System.out.println("删除");
        System.out.println("——————————删除客户——————————");
        int number;
        for (; ; ) {
            System.out.println("请选择待删除客户编号(-1退出)：");
             number = CMUtility.readInt();
            if (number == -1) {
                return;
            }

            Customer customer = customerList.getCustomerByIndex(number-1);
            if (customer == null) {
                System.out.println("无法找到客户");
            }else{
                break;
            }
        }
        // 找到了客户
        System.out.println("确认是否删除(y/n):");
        char isDelete = CMUtility.readConfirmSelection();
        if (isDelete =='Y') {
           boolean isDeleteSuccess = customerList.deleteCustomer(number-1);
            if (isDeleteSuccess) {
                System.out.println("——————————删除成功——————————");
            }else{
                System.out.println("——————————删除失败——————————");
            }
        }
    }

    // 查找所有客户
    public void listAllCustomer() {
        // System.out.println("查找");
        System.out.println("——————————客户列表——————————");
        int total = customerList.getTotal();
        if (total == 0) {
            System.out.println("没有客户记录！");
        } else {
            System.out.println("编号\t姓名\t性别\t年龄\t电话\t\t\t邮箱");
            Customer[] custs = customerList.getAllCustomer();
            for (int i = 0; i < custs.length; i++) {
                Customer cust = custs[i];
                System.out.println((i + 1) + "\t" + cust.getName() + "\t" + cust.getGender() + "\t" + cust.getAge() + "\t" + cust.getPhone() + "\t" + cust.getEmail());
            }
        }
    }


    public static void main(String[] args) {
        CustomerView customerView = new CustomerView();
        customerView.enterMainMenu();

    }
}
