package br.com.alura.mvc.mudi.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.alura.mvc.mudi.model.Pedido;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String home(Model model) {
		Pedido pedido = new Pedido();
		pedido.setNomeProduto("Xiaomi Redmi Note 8");
		pedido.setUrlImagem("https://m.media-amazon.com/images/I/51b0fG74oYL._AC_SL1000_.jpg");
		pedido.setUrlProduto("https://www.amazon.com.br/Celular-Redmi-branco-Vers%C3%A3o-Global/dp/B09D1SZZCD/ref=asc_df_B09D1SZZCD/?tag=googleshopp00-20&linkCode=df0&hvadid=379792730378&hvpos=&hvnetw=g&hvrand=542177759183153818&hvpone=&hvptwo=&hvqmt=&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=1001773&hvtargid=pla-1414472359641&psc=1");
		pedido.setDescricao("Xiaomi de última geração TOP!");
		
		List<Pedido> pedidos = Arrays.asList(pedido);
		model.addAttribute("pedidos", pedidos);
		return "home";
	}
}
