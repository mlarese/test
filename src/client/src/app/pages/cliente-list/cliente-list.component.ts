import { Component } from '@angular/core';
import { OnInit } from '@angular/core';
// Import Services
import { ClienteService } from '../../services/cliente.service';
// Import Models
import { Cliente } from '../../domain/test_db/cliente';

// START - USED SERVICES
/**
* ClienteService.delete
*	@description CRUD ACTION delete
*	@param ObjectId id Id
*
* ClienteService.list
*	@description CRUD ACTION list
*
*/
// END - USED SERVICES

/**
 * This component shows a list of Cliente
 * @class ClienteListComponent
 */
@Component({
    selector: 'app-cliente-list',
    templateUrl: './cliente-list.component.html',
    styleUrls: ['./cliente-list.component.css']
})
export class ClienteListComponent implements OnInit {
    list: Cliente[];
    search: any = {};
    idSelected: string;
    constructor(
        private clienteService: ClienteService,
    ) { }

    /**
     * Init
     */
    ngOnInit(): void {
        this.clienteService.list().subscribe(list => this.list = list);
    }

    /**
     * Select Cliente to remove
     *
     * @param {string} id Id of the Cliente to remove
     */
    selectId(id: string) {
        this.idSelected = id;
    }

    /**
     * Remove selected Cliente
     */
    deleteItem() {
        this.clienteService.remove(this.idSelected).subscribe(data => this.list = this.list.filter(el => el._id !== this.idSelected));
    }

}
