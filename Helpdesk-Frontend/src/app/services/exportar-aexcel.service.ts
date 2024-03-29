import { Injectable } from '@angular/core';
import * as FileSaver from 'file-saver';
import * as XLSX from 'xlsx';
import { Subject } from 'rxjs';
const EXCEL_TYPE = 
'application/vnd.openxmlformats-officedocument.spreadsheetml.she; charset=UTF-8'  ;
const EXCEL_EXT= '.xlsx'
@Injectable({
  providedIn: 'root'
})
export class ExportarAExcelService {

  constructor() { }

  public ticket={

    id_ticket: '',
    des_error: '',
    register_date: Date.now(),
    last_update_date: Date.now(),
    sla_status: '',
    cliente : '' ,
    estadosrepu: '',
    servicios: '',
      status_Ticket: '',
      usuarios: ''
   
  }
  
  exportHaExcel (json:any[],excelFileName: string): void{
   const workseheet : XLSX.WorkSheet =XLSX.utils.json_to_sheet(json);
   const workbook: XLSX.WorkBook= {
    Sheets:{'data':workseheet},
    SheetNames: ['data']
   };
   const excelBuffer: any =XLSX.write(workbook,{bookType: 'xlsx',type: 'array'});
  this.guardaenExcel(excelBuffer,excelFileName);
  }

  exportHaExcel_ticket (ticket2:any,excelFileName: string): void{
    const workseheet : XLSX.WorkSheet =XLSX.utils.json_to_sheet(ticket2);
    const workbook: XLSX.WorkBook= {
     Sheets:{'data':workseheet},
     SheetNames: ['data']
    };
    const excelBuffer: any =XLSX.write(workbook,{bookType: 'xlsx',type: 'array'});
   this.guardaenExcel(excelBuffer,excelFileName);
   }


  private guardaenExcel(buffer:any,fileName:string):void{
   const data: Blob=new Blob ([buffer],{type:EXCEL_TYPE});
   FileSaver.saveAs(data,fileName+'_export_'+ Date.now()+ EXCEL_EXT) ;
  }
  
}
