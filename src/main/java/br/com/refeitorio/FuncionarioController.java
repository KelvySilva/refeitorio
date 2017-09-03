package br.com.refeitorio;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.refeitorio.model.Funcionario;
import br.com.refeitorio.model.FuncionarioFlex;
import br.com.refeitorio.model.Login;
import br.com.refeitorio.repository.FuncionarioFlexRepository;
import br.com.refeitorio.repository.FuncionarioRepository;
import br.com.refeitorio.repository.LoginRepository;
import br.com.refeitorio.util.CryptUtil;

@Controller
public class FuncionarioController {

	@Autowired
	private FuncionarioRepository repository;
	@Autowired
	private FuncionarioFlexRepository flexrepository;
	@Autowired
	private LoginRepository loginrepository;

	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	/*
	public boolean login(String username, String password){
		Login login = loginrepository.findByUsername(username);
		String pass = CryptUtil.decryptPass(login.getPassword());
		return (username.equals(login.getUsername())) && (password.equals(pass));
	}
*/	
	@RequestMapping("login")
	public String mostratela(){
		return "login";
	}
	
	/*@RequestMapping(value = "entrar", method = RequestMethod.GET)
	public String entrar(@RequestParam("username") String username, @RequestParam("password") String password){
		if (this.login(username, password)) return "index";
		else return "login-error";
	}*/

	@RequestMapping("voltar")
	public String voltar() {
		return "index";
	}

	@RequestMapping("listafuncionarios")
	public String listaconvidados(Model model) {
		LocalDate localDate = LocalDate.now();
		Date date = Date.valueOf(localDate);
		Iterable<Funcionario> funcionarios = repository.findByData(date);
		model.addAttribute("funcionarios", funcionarios);
		return "listafuncionarios";
	}

	
	@RequestMapping("cadastroadmin")
	public String cadastroadmin() {
		return "cadastroadmin";
	}

	@RequestMapping(value = "cadastroadmin", method = RequestMethod.POST)
	public String cadastrar(BigDecimal id, @RequestParam("username") String username,
											   @RequestParam("name") String name, 
											   @RequestParam("password") String password) {
		byte[] pass = CryptUtil.cryptPass(password);
		Login login = new Login(id, username, name, pass);
		loginrepository.save(login);
		return "cadastroadmin";
	}
	
	@RequestMapping("cadastro")
	public String cadastro() {
		return "cadastro";
	}
	
	@RequestMapping(value = "cadastro", method = RequestMethod.POST)
	public String gravar(BigDecimal id, @RequestParam("codflex") String codflex,
			@RequestParam("nameflex") String nameflex, @RequestParam("data") Date data, Model model) {

		FuncionarioFlex funcionarioFlex = new FuncionarioFlex(id, codflex, nameflex, data);
		flexrepository.save(funcionarioFlex);
		return "cadastro";
	}

	@RequestMapping(value = "salvar", method = RequestMethod.POST)
	public String salvar(BigDecimal id, @RequestParam("codflex") String codflex, String nameflex, Date data,
			Model model) {

		LocalDate localDate = LocalDate.now();
		Date date = Date.valueOf(localDate);
		FuncionarioFlex f = flexrepository.findByCodflex(codflex);
		Funcionario funcionario = new Funcionario(id, f.getCodflex(), f.getNameflex(), date);
		repository.save(funcionario);
		Iterable<Funcionario> funcionarios = repository.findByData(date);
		model.addAttribute("funcionarios", funcionarios);
		return "listafuncionarios";
	}

}
