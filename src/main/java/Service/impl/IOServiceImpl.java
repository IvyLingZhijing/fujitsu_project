package Service.impl;

import Constants.CONSTANT;
import Entities.Employee;
import Service.IOService;
import Utils.FileUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IOServiceImpl implements IOService {

    @Override
    public Set<Employee> importEmployeeFile(String path) {

        Set<Employee> employees = new HashSet<>();

        for (String line : FileUtils.read(path)) {

            if (line.trim().startsWith(CONSTANT.COMMENT)) {
                // if line is comment, skip
                continue;
            } else {
                // if line is data, transfer to employee object
                String[] colums = line.split(CONSTANT.SPLIT_COLUM_SIGN);
                Employee employee = new Employee();
                employee.setId(Long.valueOf(colums[0].trim()));
                employee.setName(colums[1].trim());

                if (employee.getLastName() == null) {
                    continue;
                }

                int beforSize = employees.size();
                employees.add(employee);
                if (employees.size() == beforSize) {
                    System.out.println(String.format("Ops, there is Id(#%s) duplication happens.", employee.getId()));
                }
            }
        }

        return employees;
    }


    @Override
    public void outputEmployees(List<Employee> employees) {
        employees.forEach(employee -> {
            System.out.println(String.format("%s,%s %s", employee.getId(), employee.getFirstName(), employee.getLastName()));
        });
    }

}
