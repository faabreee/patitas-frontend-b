package pe.edu.cibertec.patitas_frontend_b.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pe.edu.cibertec.patitas_frontend_b.viewmodel.LoginModel;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping("/inicio")
    public String inicio(Model model){
        LoginModel loginModel = new LoginModel("00", "", "");
        model.addAttribute("loginmodel", loginModel);
        return "inicio";
    };

    @PostMapping("/autenticar")
    public String autenticar(@RequestParam("tipoDocumento") String tipoDocumento,
                                 @RequestParam("numeroDocumento") String numeroDocumento,
                                 @RequestParam("password") String password,
                                 Model model){
        var ho = tipoDocumento.trim().length();
        var h2 = numeroDocumento.trim().length();
        var h3 = password.trim().length();

        // Validar campos de entrada
        if (    tipoDocumento == null || tipoDocumento.trim().length() == 0 ||
                numeroDocumento == null || numeroDocumento.trim().length() == 0 ||
                password == null || password.trim().length() == 0
        ){
            LoginModel loginModel = new LoginModel("01", "Error: Deben completar correctamente sus credenciales", "");
            model.addAttribute("loginmodel", loginModel);
            return "inicio";
        }
        LoginModel loginModel = new LoginModel("00", "", "Bruno Diaz");
        model.addAttribute("loginmodel", loginModel);
        return "principal";
    }


}
