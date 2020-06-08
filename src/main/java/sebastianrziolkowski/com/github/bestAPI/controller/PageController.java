package sebastianrziolkowski.com.github.bestAPI.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import sebastianrziolkowski.com.github.bestAPI.staticClass.pagePath;

@Controller
public class PageController {


    @GetMapping("/panel")
    public String viewPanel() {
        return pagePath.USER_PANEL_PAGE;
    }

    @GetMapping("/userList")
    public String viewUserList() {
        return pagePath.USER_LIST_PAGE;
    }

    @GetMapping("/addUser")
    public String addUserView() {
        return pagePath.ADD_USER_PAGE;
    }

    @GetMapping("/editUser")
    public String editUserView() {
        return pagePath.EDIT_USER_PAGE;
    }

    @GetMapping("/devicesList")
    public String viewRentalDevicesList() {
        return pagePath.DEVICE_LIST_PAGE;
    }
}
