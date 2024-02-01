package br.com.lionani07.helpdesk.repositories;

import br.com.lionani07.helpdesk.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
