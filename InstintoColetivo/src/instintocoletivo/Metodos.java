package instintocoletivo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Metodos {
    
    
    public static String perguntaSePossuiCadastro() {
        Scanner teclado = new Scanner(System.in);
        String resposta;
        
        System.out.println("=== INSTINTO COLETIVO ===\n");
        System.out.println("Já possui cadastro ? ");
        System.out.println("S = SIM // N = NÃO");
        resposta = teclado.next();
        System.out.println("=============================");
        /*
        System.out.println("Bem vindo ao Instinto Coletivo \n");
	System.out.println("Denúncie e nós ajudamos! \n");
        System.out.println("Faça seu cadastro: ");
         */
        return resposta;
    }

    public static void cadastro(Usuario[] user) {
        //Adicionei
        UsuarioDao dao = new UsuarioDao();
        
        Scanner l = new Scanner(System.in);

        for (int i = 0; i < user.length; i++) {
            user[i] = new Usuario();
            System.out.println("==== CADASTRO DE USUÁRIO ====\n");

            System.out.println("Nome completo: ");
            user[i].setNome(l.nextLine());

            System.out.println("CPF: ");
            user[i].setCpf(l.next());

            System.out.println("E-mail: ");
            l.nextLine();
            user[i].setEmail(l.nextLine());

            System.out.println("Endereço: ");
            user[i].setEndereco(l.nextLine());

            System.out.println("Telefone: ");
            user[i].setTelefone(l.next());

            System.out.println("Cadastre uma senha:");
            user[i].setSenha(l.next());

            //Adicionei
            try {
                Connection con=dao.iniciar();
                dao.inserir(user[i], con);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("\n=============================");
        }
    }

    public static void exibir(Usuario[] user) {

        for (Usuario m : user) {
            if(m != null)
            {
            System.out.println(" ==== DADOS CADASTRADOS ==== "
                    + "Verifique suas informações\n");
            System.out.println("Nome: " + m.getNome());
            System.out.println("CPF: " + m.getCpf());
            System.out.println("E-mail: " + m.getEmail());
            System.out.println("Endereço: " + m.getEndereco());
            System.out.println("Telefone: " + m.getTelefone());

            System.out.println("\n");
            System.out.println("=============================\n");
            }
        }

    }

    public static String denuncia(Denuncia[] denuncia) {

        Scanner l = new Scanner(System.in);
        String respostaDois;

        for (int i = 0; i < denuncia.length; i++) {
            denuncia[i] = new Denuncia();
            System.out.println("==== CADASTRO DA DENÚNCIA ==== \n");

            System.out.println("Vamos registrar a denúncia! \n");
            System.out.println("Qual é o tipo da sua denúncia?  \n");
            System.out.println("DESMATAMENTO - QUEIMADA - CAÇA - INVASÃO DE PROPRIEDADE RURAL \n");

            System.out.println("Tipo de denúncia: ");
            denuncia[i].setTipoDenuncia(l.nextLine());

            System.out.println("Descrição da Denúncia: ");
            denuncia[i].setDescricao(l.nextLine());

            System.out.println("Local da Denúncia: ");
            denuncia[i].setEndereco(l.nextLine());
            System.out.println("\n=============================\n");
            System.out.println("DESEJA REALIZAR A DENÚNCIA EM MODO ANÔNIMO?");
            System.out.println("S = SIM // N = NÃO");
            respostaDois = l.next();
            System.out.println("=============================\n");
            return respostaDois;

        }
        System.out.println("=============================\n");

        return null;

    }

    public static void relatorioDenuncia(Denuncia[] denuncia, Usuario[] user) {

        for (Usuario m : user) {
            System.out.println("==== RELATÓRIO DA DENÚNCIA ====: \n");
            System.out.println("Nome: " + m.getNome());
            System.out.println("E-mail: " + m.getEmail());
            System.out.println("Telefone: " + m.getTelefone());
        }
        for (Denuncia d : denuncia) {
            System.out.println("Tipo da denúncia: " + d.getTipoDenuncia());
            System.out.println("Descrição de sua denúncia: " + d.getDescricao());
            System.out.println("Local da denúncia: " + d.getEndereco());

            System.out.println("\n=============================\n");
        }
    }

    public static void relatorioDenunciaAnonima(Denuncia[] denuncia) {

        for (Denuncia d : denuncia) {

            System.out.println("==== RELATÓRIO DA DENÚNCIA ====: \n");
            System.out.println("Nome: ANÔNIMO");
            System.out.println("E-mail: : ANÔNIMO");
            System.out.println("Telefone: : ANÔNIMO");
            System.out.println("Tipo da Denúncia: " + d.getTipoDenuncia());
            System.out.println("Descrição da sua Denúncia: " + d.getDescricao());
            System.out.println("Local da Denúncia: " + d.getEndereco());
            System.out.println("\n=============================\n");
        }
    }

    public static void login(Usuario[] user) {
        UsuarioDao dao = new UsuarioDao();
        Scanner l = new Scanner(System.in);

        for (int i = 0; i < user.length; i++) {
            user[i] = new Usuario();

            System.out.println("E-mail: ");
            user[i].setEmail(l.nextLine());

            System.out.println("Senha: ");
            user[i].setSenha(l.next());
            System.out.println("\n=============================\n");
            
            try {
                Connection con = dao.iniciar();
                boolean loginexiste = dao.existeUsuario(user[i].getEmail(), user[i].getSenha(), con);
                
                if(loginexiste == true){
                    //System.out.println("login existe");
                    con = dao.iniciar();
                    Usuario usuarioSelecionado = dao.selecionaUsuario(user[i].getEmail(), con);
                    if(usuarioSelecionado != null){
                        
                        user[i] = usuarioSelecionado;
                        //Usuario[] usuarios = new Usuario[1];
                        
                        //usuarios[0] = usuarioSelecionado;
                        
                        //exibir(usuarios);
                    }
                }     
                else {
                    System.out.println("Login não existe! ");
                    user[i] = null;
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
