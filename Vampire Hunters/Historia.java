public class Historia {
    public static void printIntro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("Historia");
        GameLogic.printSeparator(30);
        System.out.println("Você é um dos caçadores de vampiro, que chegou em Londres para expurgar os vampiros da cidade.");
        System.out.println("Londres atualmente se encontra infestada de vampiros, e você está aqui para matá-los");
        GameLogic.anythingToContinue();
    }

    public static void printFirstActIntro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("ATO - Introdução");
        GameLogic.printSeparator(30);
        System.out.println("Você começa sua história nos arredores de Londres, no bairro de Whitechapel");
        System.out.println("Whitechapel é famosa pelos seus mistérios e clima nebuloso.");
        System.out.println("Mas para um caçador de vampiro isso não é nada.");
    }
}