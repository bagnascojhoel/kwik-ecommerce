import {assertSameRowLength} from '../../common'
import { Table, TableHead, TableRow, TableCell, TableBody, TableContainer, Paper } from '@mui/material'

type FilteredTableProps = {
  headers: string[]
  values: string[][];
};

function Header({ headers }: Pick<FilteredTableProps, 'headers'>) {
  return <TableHead>
      <TableRow>
        {headers.map(header => <TableCell>{header}</TableCell>)}
      </TableRow>
    </TableHead>
}

function Body({values}: Pick<FilteredTableProps, 'values'>) {
  return <TableBody>
    {values.map(row => <TableRow>
      {row.map(cell => <TableCell>{cell}</TableCell>)}
      </TableRow>)}
  </TableBody>

}

function FilteredTable({ headers, values }: FilteredTableProps) {
  assertSameRowLength(headers.length, values, 'some row has different number of cells')

  return <TableContainer component={Paper}>
      <Table> 
      <Header headers={headers} />
      <Body values={values}/>
    </Table>
    </TableContainer>
}

export type { FilteredTableProps };

export { FilteredTable };
