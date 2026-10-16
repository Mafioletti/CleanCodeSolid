package repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import model.Dispositivo;

public class DispositivoRepositoryImpl implements DispositivoRepository {

    private final List<Dispositivo> dispositivos = new ArrayList<>();

    @Override
    public void salvar(Dispositivo dispositivo) {
        dispositivos.add(dispositivo);
    }

    @Override
    public List<Dispositivo> listarTodos() {
        // Retorna uma cópia não modificável da lista para proteger os dados originais
        return Collections.unmodifiableList(dispositivos);
    }

    @Override
    public Optional<Dispositivo> buscarPorCodigo(String codigo) {
        return dispositivos.stream().filter(d -> d.getCodigo().equalsIgnoreCase(codigo)).findFirst();
    }

    @Override
    public boolean estaVazio() {
        return dispositivos.isEmpty();
    }
}