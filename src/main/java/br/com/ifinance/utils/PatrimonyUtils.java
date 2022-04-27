package br.com.ifinance.utils;

import br.com.ifinance.models.entities.Patrimony;
import br.com.ifinance.models.entities.User;
import br.com.ifinance.models.enums.PatrimonyType;
import br.com.ifinance.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

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
            case "veiculos":
                for(int i = 0; i < user.getAssets().size(); i++){
                    if(user.getAssets().get(i).getPatrimonyType() == PatrimonyType.VEICULO){
                        assets.add(user.getAssets().get(i));
                    }
                }
            case "banco":
                for(int i = 0; i < user.getAssets().size(); i++){
                    if(user.getAssets().get(i).getPatrimonyType() == PatrimonyType.CONTA){
                        assets.add(user.getAssets().get(i));
                    }
                }
            case "investimentos":
                for(int i = 0; i < user.getAssets().size(); i++){
                    if(user.getAssets().get(i).getPatrimonyType() == PatrimonyType.INVESTIMENTO){
                        assets.add(user.getAssets().get(i));
                    }
                }
            case "eletronicos":
                for(int i = 0; i < user.getAssets().size(); i++){
                    if(user.getAssets().get(i).getPatrimonyType() == PatrimonyType.ELETRONICO){
                        assets.add(user.getAssets().get(i));
                    }
                }
            case "intangiveis":
                for(int i = 0; i < user.getAssets().size(); i++){
                    if(user.getAssets().get(i).getPatrimonyType() == PatrimonyType.INTANGIVEL){
                        assets.add(user.getAssets().get(i));
                    }
                }
            case "joias":
                for(int i = 0; i < user.getAssets().size(); i++){
                    if(user.getAssets().get(i).getPatrimonyType() == PatrimonyType.JOIA){
                        assets.add(user.getAssets().get(i));
                    }
                }
            case "liquidez":
                for(int i = 0; i < user.getAssets().size(); i++){
                    if(user.getAssets().get(i).getPatrimonyType() == PatrimonyType.LIQUIDEZ){
                        assets.add(user.getAssets().get(i));
                    }
                }
            case "outros":
                for(int i = 0; i < user.getAssets().size(); i++){
                    if(user.getAssets().get(i).getPatrimonyType() == PatrimonyType.OUTRO){
                        assets.add(user.getAssets().get(i));
                    }
                }
            default:
                assets.addAll(user.getAssets());
        }
        return assets;
    }

}
