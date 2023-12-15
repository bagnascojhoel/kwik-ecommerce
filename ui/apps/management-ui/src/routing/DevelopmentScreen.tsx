import { FilteredTable } from "../organisms/filtered-table/index";
function DevelopmentScreen() {
  const tableValues = [
    ['value 1', 'value 2', 'value 3'],
    ['value 1', 'value 2', 'value 3']
  ]

  return (
    <div className="">
      <FilteredTable headers={['column 1', 'column 2', 'column 3']} values={tableValues}/>
    </div>
  );
}

export { DevelopmentScreen };
