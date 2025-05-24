package com.uepb.reservas.menus;

import com.uepb.reservas.menus.MenuService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/menu")
public class MenuController {
    @Tag(name = "Menu", description = "É o menu.")
    public class ReservaController {
    
        @Autowired
        private MenuService service;
        
        
        @PostMapping("/menu inicial")
        public String menuInicial(@RequestParam int escolha) {
        return menuService.processarEscolha(escolha);
    }
}
}
