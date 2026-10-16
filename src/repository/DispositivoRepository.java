package repository;

import java.util.List;
import java.util.Optional;

import model.Dispositivo;

public interface DispositivoRepository {
    //vai salvar e adicionar um novo dispositivo
    void salvar(Dispositivo dispositivo);
    //retorna todos os dispositivos cadastrados
    List<Dispositivo> listarTodos();
    //busca um dispositivo pelo codigo dele (retorna o Optional para evitar um NullPointerException)
    Optional<Dispositivo> buscarPorCodigo(String codigo);
    //verifica se não existem dispositivos cadastrados
    boolean estaVazio();
}
