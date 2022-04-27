package br.com.ifinance.utils;

import br.com.ifinance.models.entities.Patrimony;
import br.com.ifinance.models.entities.User;
import br.com.ifinance.models.enums.PatrimonyType;
import br.com.ifinance.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PatrimonyUtils {

    @Autowired
    UserService userService;

    /*** Método utilitário que tem como objetivo filtrar a categoria que o usuário quer filtrar nos patrimônios e
     * retorna-la ao controller para que seja repassada ao usuário
     * @param user User - Usuário da sessão atual
     * @param type String - Tipo pelo qual o usuário resolveu filtrar seus patrimônios
     * @return List - Retorna a lista com todos os patrimônios do filtro selecionado */
    public List<Patrimony> patrimonyTypeFilter(User user, String type){

        List<Patrimony> assets = new ArrayList<>();
        switch (type){
            case "imoveis":
                for(int i = 0; i < user.getAssets().size(); i++){
                    if(user.getAssets().get(i).getPatrimonyType() == PatrimonyType.IMOVEL){
                        assets.add(user.getAssets().get(i));
                    }
                }
                break;
            case "veiculos":
                for(int i = 0; i < user.getAssets().size(); i++){
                    if(user.getAssets().get(i).getPatrimonyType() == PatrimonyType.VEICULO){
                        assets.add(user.getAssets().get(i));
                    }
                }
                break;
            case "banco":
                for(int i = 0; i < user.getAssets().size(); i++){
                    if(user.getAssets().get(i).getPatrimonyType() == PatrimonyType.CONTA){
                        assets.add(user.getAssets().get(i));
                    }
                }
                break;
            case "investimentos":
                for(int i = 0; i < user.getAssets().size(); i++){
                    if(user.getAssets().get(i).getPatrimonyType() == PatrimonyType.INVESTIMENTO){
                        assets.add(user.getAssets().get(i));
                    }
                }
                break;
            case "eletronicos":
                for(int i = 0; i < user.getAssets().size(); i++){
                    if(user.getAssets().get(i).getPatrimonyType() == PatrimonyType.ELETRONICO){
                        assets.add(user.getAssets().get(i));
                    }
                }
                break;
            case "intangiveis":
                for(int i = 0; i < user.getAssets().size(); i++){
                    if(user.getAssets().get(i).getPatrimonyType() == PatrimonyType.INTANGIVEL){
                        assets.add(user.getAssets().get(i));
                    }
                }
                break;
            case "joias":
                for(int i = 0; i < user.getAssets().size(); i++){
                    if(user.getAssets().get(i).getPatrimonyType() == PatrimonyType.JOIA){
                        assets.add(user.getAssets().get(i));
                    }
                }
                break;
            case "liquidez":
                for(int i = 0; i < user.getAssets().size(); i++){
                    if(user.getAssets().get(i).getPatrimonyType() == PatrimonyType.LIQUIDEZ){
                        assets.add(user.getAssets().get(i));
                    }
                }
                break;
            case "outros":
                for(int i = 0; i < user.getAssets().size(); i++){
                    if(user.getAssets().get(i).getPatrimonyType() == PatrimonyType.OUTRO){
                        assets.add(user.getAssets().get(i));
                    }
                }
                break;
            case "all":
                assets.addAll(user.getAssets());
                break;
        }
        return assets;
    }

    /** Método utilitário que tem como objetivo somar o valor total de cada categoria de patrimônios do usuário
     * @param user User - Usuário logado na sessão atual
     * @return Map - Map contendo os valores totais de cada tipo de patrimônio do usuário */
    public Map<PatrimonyType, Double> patrimonySum(User user){

        Map<PatrimonyType, Double> sums = new HashMap<>();

        sums.put(PatrimonyType.IMOVEL, 0.0);
        sums.put(PatrimonyType.VEICULO, 0.0);
        sums.put(PatrimonyType.CONTA, 0.0);
        sums.put(PatrimonyType.INVESTIMENTO, 0.0);
        sums.put(PatrimonyType.ELETRONICO, 0.0);
        sums.put(PatrimonyType.INTANGIVEL, 0.0);
        sums.put(PatrimonyType.JOIA, 0.0);
        sums.put(PatrimonyType.LIQUIDEZ, 0.0);
        sums.put(PatrimonyType.OUTRO, 0.0);

        for(int i = 0; i < user.getAssets().size(); i++){

            switch (user.getAssets().get(i).getPatrimonyType()) {

                case IMOVEL:
                    sums.put(PatrimonyType.IMOVEL, sums.get(PatrimonyType.IMOVEL)
                            + user.getAssets().get(i).getValue());
                    break;
                case VEICULO:
                    sums.put(PatrimonyType.VEICULO, sums.get(PatrimonyType.VEICULO)
                            + user.getAssets().get(i).getValue());
                    break;
                case CONTA:
                    sums.put(PatrimonyType.CONTA, sums.get(PatrimonyType.CONTA)
                            + user.getAssets().get(i).getValue());
                    break;
                case INVESTIMENTO:
                    sums.put(PatrimonyType.INVESTIMENTO, sums.get(PatrimonyType.INVESTIMENTO)
                            + user.getAssets().get(i).getValue());
                    break;
                case ELETRONICO:
                    sums.put(PatrimonyType.ELETRONICO, sums.get(PatrimonyType.ELETRONICO)
                            + user.getAssets().get(i).getValue());
                    break;
                case INTANGIVEL:
                    sums.put(PatrimonyType.INTANGIVEL, sums.get(PatrimonyType.INTANGIVEL)
                            + user.getAssets().get(i).getValue());
                    break;
                case JOIA:
                    sums.put(PatrimonyType.JOIA, sums.get(PatrimonyType.JOIA)
                            + user.getAssets().get(i).getValue());
                    break;
                case LIQUIDEZ:
                    sums.put(PatrimonyType.LIQUIDEZ, sums.get(PatrimonyType.LIQUIDEZ)
                            + user.getAssets().get(i).getValue());
                    break;
                case OUTRO:
                    sums.put(PatrimonyType.OUTRO, sums.get(PatrimonyType.OUTRO)
                            + user.getAssets().get(i).getValue());
                    break;

            }
        }

        return sums;

    }

    public Double patrimonyAllSum(User user){

        Double total = 0.0;
        for(Map.Entry<PatrimonyType, Double> totalMap : patrimonySum(user).entrySet()){
            total += totalMap.getValue();
        }
        return total;

    }



}
