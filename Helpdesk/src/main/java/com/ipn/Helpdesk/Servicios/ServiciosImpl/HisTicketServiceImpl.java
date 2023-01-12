package com.ipn.Helpdesk.Servicios.ServiciosImpl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipn.Helpdesk.Servicios.HisTicketService;
import com.ipn.Helpdesk.modelo.entidad.HisTicket;
import com.ipn.Helpdesk.repositorios.HisTicketRepository;

@Service
public class HisTicketServiceImpl implements HisTicketService {
	@Autowired
	private HisTicketRepository hisTicketRepository;

	@Override
	public HisTicket AgregarHistorialTicket(HisTicket hisTicket) {
		// TODO Auto-generated method stub
		return hisTicketRepository.save(hisTicket);
	}

	@Override
	public HisTicket ActualizarHistorialTicket(HisTicket hisTicket) {
		// TODO Auto-generated method stub
		return hisTicketRepository.save(hisTicket);
	}

	@Override
	public Set<HisTicket> ListarHistorialesTickes() {
		// TODO Auto-generated method stub
		return new LinkedHashSet<>(hisTicketRepository.findAll());
	}

	@Override
	public HisTicket AgregarHistorialTicket(Long Id_histTicket) {
		// TODO Auto-generated method stub
		return hisTicketRepository.findById(Id_histTicket).get();
	}

	@Override
	public void EliminarHistorialTicket(Long Id_histTicket) {
		// TODO Auto-generated method stub
		HisTicket hisTicketEliminado = new HisTicket();
		hisTicketEliminado.setId_histori(Id_histTicket);
		hisTicketRepository.delete(hisTicketEliminado);

	}

}
