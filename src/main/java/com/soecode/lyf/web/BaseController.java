package com.soecode.lyf.web;

import com.soecode.lyf.entity.*;
import com.soecode.lyf.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/21.
 *
 * @author ZLC
 */
@Controller
@RequestMapping("base") // url:/模块/资源/{id}/细分 /seckill/list
public class BaseController {
    @Autowired
    SupplyService supplyService;
    @Autowired
    ProductService productService;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    PowerService powerService;
    @RequestMapping("/supply/list")
    public String base_supply(HttpServletRequest request){
        List<Supply> list= supplyService.selectAll();
        request.setAttribute("supplyList",list);
        return "base_supply";
    }
    @RequestMapping("/supply/add")
    public String base_supply_add(HttpServletRequest request){
        List<Product> list= productService.selectAll();
        request.setAttribute("productList",list);
        return "base_supply_add";
    }
    @RequestMapping("/supply/{supply_Id}/delete")
    public String base_supply_delete(@PathVariable("supply_Id") Integer supply_Id,HttpServletRequest request){
        supplyService.deleteByPK(supply_Id);
        List<Supply> list= supplyService.selectAll();
        request.setAttribute("supplyList",list);
        return "base_supply";
    }
    @RequestMapping("/supply/{supply_Id}/update")
    public String base_supply_update(@PathVariable("supply_Id") Integer supply_Id,HttpServletRequest request){
        Supply s=supplyService.selectSByPk(supply_Id);
        List<supplyProduct> listsp=supplyService.selectSPbySPK(supply_Id);
        List<Integer> listl=new ArrayList<>();
        for (supplyProduct sp:listsp
             ) {
            listl.add(sp.getProductId());
        }
        request.setAttribute("supply",s);
        request.setAttribute("selectedproduct",listl);
        List<Product> list= productService.selectAll();
        request.setAttribute("productList",list);
        return "base_supply_add";
    }
    @RequestMapping("/supply/update/commit")
    public String base_supply_update(Supply supply,Integer[] projectId, HttpServletRequest request){
        supplyService.deleteByPK(supply.getSupplyId());
        supplyService.insertSelective(supply);

        for (int i=0;i<projectId.length;i++
                ) {
            Integer pid=projectId[i];
            supplyProduct s=new supplyProduct();
            if(pid!=null){
                s.setProductId(pid);
                s.setSupplyId(supply.getSupplyId());
                supplyService.insertSupplyPSelective(s);
            }

        }
        List<Supply> list= supplyService.selectAll();
        request.setAttribute("supplyList",list);
        return "base_supply";
    }



    @RequestMapping(value="/supply/add/commit" ,produces={"text/html;charset=UTF-8;","application/json;"})
    public String base_supply_add(Supply supply,Integer[] projectId, HttpServletRequest request){
        int supply_id=supplyService.insertSelective(supply);

        for (Integer id:projectId
             ) {
                supplyProduct sp=new supplyProduct();
                if(id!=null){
                    sp.setProductId(id);
                    sp.setSupplyId(supply.getSupplyId());
                    supplyService.insertSupplyPSelective(sp);
                }

        }
        List<Supply> list= supplyService.selectAll();
        request.setAttribute("supplyList",list);
        System.out.println("supply = [" + supply + "], list = [" + list + "], request = [" + request + "]");
        return "base_supply";
    }

    @RequestMapping("/product/list")
    public String base_product(HttpServletRequest request){
        List<Product> list= productService.selectAll();
        request.setAttribute("productList",list);
        return "base_product";
    }
    @RequestMapping("/product/add")
    public String base_product_add(HttpServletRequest request){
        return "base_product_add";
    }
    @RequestMapping("/product/{product_Id}/delete")
    public String base_product_delete(@PathVariable("product_Id") Integer supply_Id,HttpServletRequest request){
        productService.deleteByPK(supply_Id);
        List<Product> list= productService.selectAll();
        request.setAttribute("productList",list);
        return "base_product";
    }
    @RequestMapping("/product/{product_Id}/update")
    public String base_product_update(@PathVariable("product_Id") Integer product_Id,HttpServletRequest request){
        Product p=productService.selectByPK(product_Id);


        request.setAttribute("product",p);
        return "base_product_add";
    }
    @RequestMapping("/product/update/commit")
    public String base_product_update(Product product, HttpServletRequest request){
        productService.update(product);

        List<Product> list= productService.selectAll();
        request.setAttribute("productList",list);
        return "base_product";
    }



    @RequestMapping(value="/product/add/commit" ,produces={"text/html;charset=UTF-8;","application/json;"})
    public String base_product_add(String[] productName, HttpServletRequest request){
       for(int i=0;i<productName.length;i++){
           Product p=new Product();
           p.setProductName(productName[i]);
           productService.insertProduct(p);
       }

        List<Product> list= productService.selectAll();
        request.setAttribute("productList",list);
        return "base_product";
    }

    @RequestMapping("/department/list")
    public String base_department(HttpServletRequest request){
        List<Department> list= departmentService.selectAll();
        request.setAttribute("departmentList",list);
        return "base_department";
    }
    @RequestMapping("/department/add")
    public String base_department_add(HttpServletRequest request){
        return "base_department_add";
    }
    @RequestMapping("/department/{department_Id}/delete")
    public String base_department_delete(@PathVariable("department_Id") Integer department_Id,HttpServletRequest request){
        productService.deleteByPK(department_Id);
        List<Department> list= departmentService.selectAll();
        request.setAttribute("departmentList",list);
        return "base_department";
    }
    @RequestMapping("/department/{department_Id}/update")
    public String base_department_update(@PathVariable("department_Id") Integer department_Id,HttpServletRequest request){
        Department p=departmentService.selectByPK(department_Id);


        request.setAttribute("department",p);
        return "base_department_add";
    }
    @RequestMapping("/department/update/commit")
    public String base_department_update(Department department, HttpServletRequest request){
        departmentService.update(department);

        List<Department> list= departmentService.selectAll();
        request.setAttribute("departmentList",list);
        return "base_department";
    }



    @RequestMapping(value="/department/add/commit" ,produces={"text/html;charset=UTF-8;","application/json;"})
    public String base_department_add(String[] departmentName, HttpServletRequest request){
        for(int i=0;i<departmentName.length;i++){
            Department p=new Department();
            p.setDepartmentName(departmentName[i]);
            departmentService.insertDepartment(p);
        }

        List<Department> list= departmentService.selectAll();
        request.setAttribute("departmentList",list);
        return "base_department";
    }

    @RequestMapping("/user/list")
    public String base_user(HttpServletRequest request){
        List<User> list= userService.getuserAll();
        request.setAttribute("userList",list);
        return "base_user";
    }
    @RequestMapping("/user/add")
    public String base_user_add(HttpServletRequest request){
        List<Role> list= roleService.selectAll();
        request.setAttribute("roleList",list);
        List<Department> listd=departmentService.selectAll();
        request.setAttribute("departmentList",listd);
        return "base_user_add";
    }
    @RequestMapping("/user/{user_Id}/delete")
    public String base_user_delete(@PathVariable("user_Id") Integer user_Id,HttpServletRequest request){
        userService.deleteUser(user_Id);
        List<User> list= userService.getuserAll();
        request.setAttribute("userList",list);
        return "base_user";
    }
    @RequestMapping("/user/{user_Id}/update")
    public String base_user_update(@PathVariable("user_Id") Integer user_Id,HttpServletRequest request){
        User u=userService.getUserByPK(user_Id);
        List<userRole> listsp=userService.getAllUserRole(user_Id);
        List<Integer> listl=new ArrayList<>();
        for (userRole ur:listsp
                ) {
            listl.add(ur.getRoleId());
        }
        request.setAttribute("user",u);
        request.setAttribute("selectedrole",listl);
        List<Role> list= roleService.selectAll();
        request.setAttribute("roleList",list);
        List<Department> listd=departmentService.selectAll();
        request.setAttribute("departmentList",listd);
        return "base_user_add";
    }
    @RequestMapping("/user/update/commit")
    public String base_user_update(User user,Integer[] projectId, HttpServletRequest request){
        userService.deleteUser(user.getUserId());
        userService.insertUser(user);

        for (int i=0;i<projectId.length;i++
                ) {
            Integer pid=projectId[i];
            userRole u=new userRole();
            if(pid!=null){
                u.setRoleId(pid);
                u.setUserId(user.getUserId());
                userService.insertUserRole(u);
            }

        }
        List<User> list= userService.getuserAll();
        request.setAttribute("userList",list);
        return "base_user";
    }



    @RequestMapping(value="/user/add/commit" ,produces={"text/html;charset=UTF-8;","application/json;"})
    public String base_user_add(User user,Integer[] projectId, HttpServletRequest request){
        int user_id=userService.insertUser(user);

        for (Integer id:projectId
                ) {
            userRole ur=new userRole();
            if(id!=null){
                ur.setUserId(user.getUserId());
                ur.setRoleId(id);
                System.out.println("user = [" + user + "], projectId = [" + projectId + "], request = [" + request + "]");
                userService.insertUserRole(ur);
            }

        }
        List<User> list= userService.getuserAll();
        request.setAttribute("userList",list);
        return "base_user";
    }

    @RequestMapping("/role/list")
    public String base_role(HttpServletRequest request){
        List<Role> list= roleService.selectAll();
        request.setAttribute("roleList",list);
        List<Power> powers=powerService.selectAll();
        request.setAttribute("powerList",powers);
        return "base_role";
    }
    @RequestMapping("/role/add")
    public String base_role_add(HttpServletRequest request){
        List<Power> listd=powerService.selectAll();
        request.setAttribute("powerList",listd);
        return "base_role_add";
    }
    @RequestMapping("/role/{role_Id}/delete")
    public String base_role_delete(@PathVariable("role_Id") Integer role_Id,HttpServletRequest request){
        roleService.delete(role_Id);
        List<Role> list= roleService.selectAll();
        request.setAttribute("roleList",list);
        List<Power> powers=powerService.selectAll();
        request.setAttribute("powerList",powers);
        return "base_role";
    }
    @RequestMapping("/role/{role_Id}/update")
    public String base_role_update(@PathVariable("role_Id") Integer role_Id,HttpServletRequest request){
        Role u=roleService.selectByPK(role_Id);
        List<Role_Result> listsp=roleService.getAllById(role_Id);
        List<Integer> listl=new ArrayList<>();
        for (Role_Result ur:listsp
                ) {
            listl.add(ur.getPowerId());
        }
        request.setAttribute("role",u);
        request.setAttribute("selectedpower",listl);
        List<Power> listp=powerService.selectAll();
        request.setAttribute("powerList",listp);
        return "base_role_add";
    }
    @RequestMapping("/role/update/commit")
    public String base_role_update(Role role,Integer[] projectId, HttpServletRequest request){
        roleService.delete(role.getRoleId());
        roleService.insertRole(role);

        for (int i=0;i<projectId.length;i++
                ) {
            Integer pid=projectId[i];
            rolePower u=new rolePower();
            if(pid!=null){
                u.setPowerId(pid);
                u.setRoleId(role.getRoleId());
                roleService.insertRP(u);
            }

        }
        List<Role> list= roleService.selectAll();
        request.setAttribute("roleList",list);
        List<Power> powers=powerService.selectAll();
        request.setAttribute("powerList",powers);
        return "base_role";
    }



    @RequestMapping(value="/role/add/commit" ,produces={"text/html;charset=UTF-8;","application/json;"})
    public String base_role_add(Role role,Integer[] projectId, HttpServletRequest request){
        int user_id=roleService.insertRole(role);

        for (Integer id:projectId
                ) {
            rolePower ur=new rolePower();
            if(id!=null){
                ur.setRoleId(role.getRoleId());
                ur.setPowerId(id);
                roleService.insertRP(ur);
            }

        }
        List<Role> list= roleService.selectAll();
        request.setAttribute("roleList",list);
        List<Power> powers=powerService.selectAll();
        request.setAttribute("powerList",powers);
        return "base_role";
    }
}
