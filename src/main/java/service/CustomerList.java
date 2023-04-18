package service;

import bean.Customer;

public class CustomerList {
    private Customer[] customers;//用来保存客户对象的数组
    private int total = 0;//记录已保存客户对象的数量

    public CustomerList(int totalCustomer) {
        customers = new Customer[totalCustomer];
    }

    // 增加客户
    public boolean addCustomer(Customer customer) {
        if (total >= customers.length) {
            return false;
        }
        customers[total++] = customer;
        return true;
    }

    // 修改客户
    public boolean replaceCustomer(int index, Customer cust) {
        if (index < 0 || index >= total) {
            return false;
        }
        customers[index] = cust;
        return true;
    }
    // 删除客户
    public boolean deleteCustomer(int index){
        if (index < 0 || index >= total) {
            return false;
        }
        for (int i = index; i < total-1; i++) {
            customers[i] = customers[i+1];
        }
        // 最后的数据置空null
        customers[--total] = null;
        return true;
    }
    // 获取所有客户信息
    public Customer[] getAllCustomer(){
        Customer[] newCust = new Customer[total];
        for (int i = 0; i < total; i++) {
            newCust[i] = customers[i];
        }
        return newCust;
    }
    // 获取指定索引客户
    public Customer getCustomerByIndex(int index){
        if (index < 0 || index >= total) {
            return null;
        }
        return customers[index];
    }
    // 获取客户数量
    public int getTotal(){
        return total;
    }

}
