package org.um5.ensias.ims.cbpm.transformation.Sevice.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.um5.ensias.ims.cbpm.transformation.Repository.CbpmnElementRepository;
import org.um5.ensias.ims.cbpm.transformation.Sevice.CrudCbpmElementService;
import org.um5.ensias.ims.cbpm.transformation.model.CbpmElement;
import org.um5.ensias.ims.cbpm.transformation.model.Event;
import org.um5.ensias.ims.cbpm.transformation.model.Gateway;
import org.um5.ensias.ims.cbpm.transformation.model.Service;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class CrudCbpmElementServiceImp implements CrudCbpmElementService {

    @Autowired
    CbpmnElementRepository cbpmnElementRepository;

    @Override
    public List<CbpmElement> findAll() {
        return cbpmnElementRepository.findAll();
    }

    @Override
    public Optional<CbpmElement> findById(long id) {
        return cbpmnElementRepository.findById(id);
    }

    @Override
    public void deleteById(long id) {
        cbpmnElementRepository.deleteById(id);
    }

    @Override
    public CbpmElement create(CbpmElement cbpmElement) {
        return (CbpmElement) cbpmnElementRepository.save(cbpmElement);
    }

    @Override
    public CbpmElement update(CbpmElement cbpmElement) {
        return (CbpmElement) cbpmnElementRepository.save(cbpmElement);
    }

    @Autowired
    CbpmnElementRepository<Event> eventCbpmnElementRepository;

    @Override
    public List<Event> findAllEvent() {
        return eventCbpmnElementRepository.findAll();
    }

    @Override
    public Optional<Event> findEventById(long id) {
        return eventCbpmnElementRepository.findById(id);
    }

    @Override
    public void deleteEventById(long id) {
        eventCbpmnElementRepository.deleteById(id);
    }

    @Override
    public Event createEvent(Event event) {
        return eventCbpmnElementRepository.save(event);
    }

    @Override
    public Event updateEvent(Event event) {
        return eventCbpmnElementRepository.save(event);
    }

    @Autowired
    CbpmnElementRepository<Gateway> gatewayCbpmnElementRepository;

    @Override
    public List<Gateway> findAllGateway() {
        return gatewayCbpmnElementRepository.findAll();
    }

    @Override
    public Optional<Gateway> findGatewayById(long id) {
        return gatewayCbpmnElementRepository.findById(id);
    }

    @Override
    public void deleteGatewayById(long id) {
        gatewayCbpmnElementRepository.deleteById(id);
    }

    @Override
    public Gateway createGateway(Gateway gateway) {
        return gatewayCbpmnElementRepository.save(gateway);
    }

    @Override
    public Gateway updateGateway(Gateway gateway) {
        return gatewayCbpmnElementRepository.save(gateway);
    }

    @Autowired
    CbpmnElementRepository<Service> serviceCbpmnElementRepository;

    @Override
    public List<Service> findAllService() {
        return serviceCbpmnElementRepository.findAll();
    }

    @Override
    public Optional<Service> findServiceById(long id) {
        return serviceCbpmnElementRepository.findById(id);
    }

    @Override
    public void deleteServiceById(long id) {
        serviceCbpmnElementRepository.deleteById(id);
    }

    @Override
    public Service createService(Service service) {
        return serviceCbpmnElementRepository.save(service);
    }

    @Override
    public Service updateService(Service service) {
        return serviceCbpmnElementRepository.save(service);
    }
}