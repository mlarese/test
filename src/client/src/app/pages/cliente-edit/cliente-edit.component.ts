// Import Libraries
import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
// Import Services
import { ClienteService } from '../../services/cliente.service';
import { ProgettoService } from '../../services/progetto.service';
// Import Models
import { Cliente } from '../../domain/test_db/cliente';
import { Progetto } from '../../domain/test_db/progetto';

// START - USED SERVICES
/**
* ClienteService.create
*	@description CRUD ACTION create
*
* ClienteService.update
*	@description CRUD ACTION update
*	@param ObjectId id Id
*
* ClienteService.get
*	@description CRUD ACTION get
*	@param ObjectId id Id resource
*
* ProgettoService.findByCliente
*	@description CRUD ACTION findByCliente
*	@param Objectid key Id of model to search for
*
*/
// END - USED SERVICES

/**
 * This component allows to edit a Cliente
 */
@Component({
    selector: 'app-cliente-edit',
    templateUrl: 'cliente-edit.component.html',
    styleUrls: ['cliente-edit.component.css']
})
export class ClienteEditComponent implements OnInit {
    item: Cliente;
    externalProgetto_Cliente: Progetto[];
    model: Cliente;
    formValid: Boolean;

    constructor(
    private clienteService: ClienteService,
    private progettoService: ProgettoService,
    private route: ActivatedRoute,
    private location: Location) {
        // Init item
        this.item = new Cliente();
        this.externalProgetto_Cliente = [];
    }

    /**
     * Init
     */
    ngOnInit() {
        this.route.params.subscribe(param => {
            const id: string = param['id'];
            if (id !== 'new') {
                this.clienteService.get(id).subscribe(item => this.item = item);
                this.progettoService.findByCliente(id).subscribe(list => this.externalProgetto_Cliente = list);
            }
            // Get relations
        });
    }


    /**
     * Save Cliente
     *
     * @param {boolean} formValid Form validity check
     * @param Cliente item Cliente to save
     */
    save(formValid: boolean, item: Cliente): void {
        this.formValid = formValid;
        if (formValid) {
            if (item._id) {
                this.clienteService.update(item).subscribe(data => this.goBack());
            } else {
                this.clienteService.create(item).subscribe(data => this.goBack());
            } 
        }
    }

    /**
     * Go Back
     */
    goBack(): void {
        this.location.back();
    }


}



