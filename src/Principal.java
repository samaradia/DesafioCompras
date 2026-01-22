import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        // Scanner serve para ler dados digitados pelo usuário
        Scanner leitura = new Scanner(System.in);

        // Pede o limite do cartão
        System.out.println("Digite o limite do cartão: ");
        double limite = leitura.nextDouble();

        // Cria o cartão de crédito com o limite informado
        CartaoDeCredito cartao = new CartaoDeCredito(limite);

        // Variável de controle do loop
        // 1 = continua | 0 = sai
        int sair = 1;

        // Enquanto sair for diferente de 0, o programa continua
        while (sair != 0) {

            // Pede a descrição da compra
            System.out.println("Digite a descrição da compra:");
            String descricao = leitura.next();

            // Pede o valor da compra
            System.out.println("Digite o valor da compra:");
            double valor = leitura.nextDouble();

            // Cria um objeto Compra com descrição e valor
            Compra compra = new Compra(descricao, valor);

            // Tenta lançar a compra no cartão
            // Retorna true (aprovada) ou false (negada)
            boolean compraRealizada = cartao.lancaCompra(compra);

            // Se a compra foi realizada
            if (compraRealizada) {
                System.out.println("Compra realizada!");

                // Pergunta se o usuário quer continuar
                System.out.println("Digite 0 para sair ou 1 para continuar");
                sair = leitura.nextInt();

            } else {
                // Se não tiver saldo suficiente
                System.out.println("Saldo insuficiente!");

                // Força a saída do loop
                sair = 0;
            }
        }

        // Exibe as compras realizadas
        System.out.println("***********************");
        System.out.println("COMPRAS REALIZADAS:\n");

        // Percorre a lista de compras do cartão
        for (Compra c : cartao.getCompras()) {
            System.out.println(c.getDescricao() + " - " + c.getValor());
        }

        System.out.println("\n***********************");

        // Mostra o saldo final do cartão
        System.out.println("\nSaldo do cartão: " + cartao.getSaldo());
    }
}
