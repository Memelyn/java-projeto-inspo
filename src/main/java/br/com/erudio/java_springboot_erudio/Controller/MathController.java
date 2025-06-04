//package br.com.erudio.java_springboot_erudio.Controller;
//
//
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController // para que saiba que é um controller rest
//@RequestMapping("/math")
//
//// @PathVariable usada para recuperar dados da URL, permite que o controller
//// lide com requisições URL parametrizadas, como URLs que possuem entradas de variáveis como parte do seu path
//
///* @RequestMapping a classe controller contém vários métodos manipuladores para gerenciar
//// diferentes requisições HTTP, usada para o spring mapear uma requisição específica para um
//// método manipulador específico
//// é colocada sobre um método e fornece um mapeamento entre o caminho da requisição e o método manipulador*/
//public class MathController {
//
//    @RequestMapping("/sum/{numberOne}/{numberTwo}") // para saber que o /sum é disponibilizado através do HTTP
//    public Double sum (
//         @PathVariable("numberOne")  String numberOne, //para saber em qual local o requestMapping vai atribuir na URL
//         @PathVariable("numberTwo")  String numberTwo
//    ) throws Exception {
//        // verifica se os parâmetros são numéricos
////        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Set a numeric value");
////        return convertToDouble(numberOne) + convertToDouble(numberTwo);
//        // não usamos double pq vamos fazer validações antes de converter
//    }
//
//    @RequestMapping("/sub/{numberOne}/{numberTwo}")
//    public Double sub (
//            @PathVariable("numberOne")  String numberOne,
//            @PathVariable("numberTwo")  String numberTwo
//    ) throws Exception {
//        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Set a numeric value");
//        return convertToDouble(numberOne) - convertToDouble(numberTwo);
//    }
//
//    @RequestMapping("/division/{numberOne}/{numberTwo}")
//    public Double division (
//            @PathVariable("numberOne")  String numberOne,
//            @PathVariable("numberTwo")  String numberTwo
//    ) throws Exception {
//        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Set a numeric value");
//        return convertToDouble(numberOne) / convertToDouble(numberTwo);
//    }
//
//    @RequestMapping("/multiplication/{numberOne}/{numberTwo}")
//    public Double multiplication (
//            @PathVariable("numberOne")  String numberOne,
//            @PathVariable("numberTwo")  String numberTwo
//    ) throws Exception {
//        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Set a numeric value");
//        return convertToDouble(numberOne) * convertToDouble(numberTwo);
//    }
//
//    @RequestMapping("/media/{numberOne}/{numberTwo}")
//    public Double media (
//            @PathVariable("numberOne")  String numberOne,
//            @PathVariable("numberTwo")  String numberTwo
//    ) throws Exception {
//        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Set a numeric value");
//        return convertToDouble(numberOne) + convertToDouble(numberTwo)/2;
//    }
//
////    @RequestMapping("/sqrt/{numberOne}")
////    public Double sqrt (
////            @PathVariable("numberOne")  String numberOne
////    ) throws Exception {
////        if(!isNumeric(numberOne)) throw new UnsupportedMathOperationException("Set a numeric value");
////        return Math.sqrt(convertToDouble(numberOne));
////    }
//
//    private Double convertToDouble(String strNumber) throws IllegalArgumentException{
//        if (strNumber == null || strNumber.isEmpty()) throw new IllegalArgumentException();
//        String number = strNumber.replace(",",".");
//        return Double.parseDouble(number);
//
//    }
//
//    private boolean isNumeric(String strNumber)  {
//        if (strNumber == null || strNumber.isEmpty());
//        String number = strNumber.replace(",",".");
//        return number.matches("[-+]?[0-9]*\\.?[0-9]+"); // aceita numeros positivos e negativos, que vão de 0 a 9, tem um separador ponto
//        // e após a virgula também vai de 0 a 9
//    }
//}
