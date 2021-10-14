package instintocoletivo;

public class InstintoColetivo {

    public static void main(String[] args) {
   
        Usuario[] user = new Usuario[1];
        Denuncia[] denuncia = new Denuncia[1];

        String respostaUm = Metodos.perguntaSePossuiCadastro();

        if (null == respostaUm) {
            System.out.println("OPÇÃO INVÁLIDA");
            System.out.println("Finalizando execução...");
            System.exit(0);
        } else switch (respostaUm) {
            case "S":
            case "s":
                Metodos.login(user);
                Metodos.exibir(user);
                break;
            case "N":
            case "n":
                Metodos.cadastro(user);
                Metodos.exibir(user);
                System.out.println("Seu cadastro foi realizado com sucesso! ");
                break;
            default:
                System.out.println("OPÇÃO INVÁLIDA");
                System.out.println("Finalizando execução...");
                System.exit(0);
        }

        System.out.println("BEM-VINDO!");

        System.out.println("\n");

        String respostaDois = Metodos.denuncia(denuncia);

        if (null == respostaDois) {
            System.out.println("OPÇÃO INVÁLIDA");
            System.out.println("Finalizando execução...");
            System.exit(0);
        } else switch (respostaDois) {
            case "S":
            case "s":
                Metodos.relatorioDenunciaAnonima(denuncia);
                break;
            case "N":
            case "n":
                Metodos.relatorioDenuncia(denuncia, user);
                break;
            default:
                System.out.println("OPÇÃO INVÁLIDA");
                System.out.println("Finalizando execução...");
                System.exit(0);
        }
        
        System.out.println("PARABÉNS, DENÚNCIA REGISTRADA COM SUCESSO!\n");
        System.out.println("Sua solicitação foi direcionada à polícia ambiental.");
        System.out.println("Aguarde passo a passo via SMS!");
        System.out.println("OBRIGADO POR FAZER A SUA PARTE! \n");
    }
}