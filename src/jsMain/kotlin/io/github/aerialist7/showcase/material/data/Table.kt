package io.github.aerialist7.showcase.material.data

import `<dynamic>`.get
import js.objects.jso
import mui.material.*
import mui.material.DividerVariant.Companion.fullWidth
import mui.system.sx
import react.FC
import react.Props
import react.ReactNode
import react.create
import react.dom.aria.AriaRole
import react.dom.html.ReactHTML.th
import web.cssom.Length
import web.cssom.pct
import web.cssom.px

val TableShowcase = FC<Props> {
    Divider {
        variant = fullWidth

        Chip {
            label = ReactNode("Basic table")
        }
    }
    TableContainer {
        component = Paper.create().type

        Table {
            sx { minWidth = 650.px }
            ariaLabel = "simple table"

            TableHead {
                TableRow {
                    TableCell {
                        +"Dessert (100 g serving)"
                    }
                    TableCell {
                        align = TableCellAlign.right

                        +"Calories"
                    }
                    TableCell {
                        align = TableCellAlign.right

                        +"Fat (g)"
                    }
                    TableCell {
                        align = TableCellAlign.right

                        +"Carbs (g)"
                    }
                    TableCell {
                        align = TableCellAlign.right

                        +"Protein (g)"
                    }
                }
            }
            TableBody {
                for (row in basicTableRows) {
                    TableRow {
                        key = row.name

                        TableCell {
                            component = th
                            scope = "row"

                            +row.name
                        }
                        TableCell {
                            align = TableCellAlign.right

                            +"${row.calories}"
                        }
                        TableCell {
                            align = TableCellAlign.right

                            +"${row.fat}"
                        }
                        TableCell {
                            align = TableCellAlign.right

                            +"${row.carbs}"
                        }
                        TableCell {
                            align = TableCellAlign.right

                            +"${row.protein}"
                        }
                    }
                }
            }
        }
    }

    Divider {
        variant = fullWidth

        Chip {
            label = ReactNode("Column grouping")
        }
    }
    Paper {
        sx { width = 100.pct }

        TableContainer {
            sx { maxHeight = 440.px }

            Table {
                stickyHeader = true
                ariaLabel = "sticky table"

                TableHead {
                    TableRow {
                        TableCell {
                            align = TableCellAlign.center
                            colSpan = 2

                            +"Country"
                        }
                        TableCell {
                            align = TableCellAlign.center
                            colSpan = 3

                            +"Details"
                        }
                    }

                    TableRow {
                        for (column in columnGroupingColumns) {
                            TableCell {
                                key = column.id
                                align = column.align
                                style = jso {
                                    top = 57.px
                                    minWidth = column.minWidth
                                }

                                +column.label
                            }
                        }
                    }

                }

                TableBody {
                    for (row in columnGroupingRows) {
                        TableRow {
                            key = row.code
                            hover = true
                            role = AriaRole.checkbox
                            tabIndex = -1

                            for (column in columnGroupingColumns) {
                                val value: String = row.asDynamic()[column.id]

                                TableCell {
                                    key = column.id
                                    align = column.align

                                    +value
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

private data class BasicTableData(
    val name: String,
    val calories: Int,
    val fat: Double,
    val carbs: Int,
    val protein: Double,
)

private val basicTableRows = setOf(
    BasicTableData("Frozen yoghurt", 159, 6.0, 24, 4.0),
    BasicTableData("Ice cream sandwich", 237, 9.0, 37, 4.3),
    BasicTableData("Eclair", 262, 16.0, 24, 6.0),
    BasicTableData("Cupcake", 305, 3.7, 67, 4.3),
    BasicTableData("Gingerbread", 356, 16.0, 49, 3.9),
)

private val columnGroupingColumns = setOf(
    ColumnGroupingColumn("name", "Name", 170.px, TableCellAlign.left),
    ColumnGroupingColumn("code", "ISO Code", 100.px, TableCellAlign.left),
    ColumnGroupingColumn("population", "Population", 170.px, TableCellAlign.right),
    ColumnGroupingColumn("size", "Size (km²)", 170.px, TableCellAlign.right),
    ColumnGroupingColumn("density", "Density", 170.px, TableCellAlign.right),
)

private val columnGroupingRows = setOf(
    ColumnGroupingRow("India", "IN", "1,324,171,354", "3,287,263", "402.82"),
    ColumnGroupingRow("China", "CN", "1,403,500,365", "9,596,961", "146.24"),
    ColumnGroupingRow("Italy", "IT", "60,483,973", "301,340", "200.72"),
    ColumnGroupingRow("United States", "US", "327,167,434", "9,833,520", "33.27"),
    ColumnGroupingRow("Canada", "CA", "37,602,103", "9,984,670", "3.77"),
    ColumnGroupingRow("Australia", "AU", "25,475,400", "7,692,024", "3.31"),
    ColumnGroupingRow("Germany", "DE", "83,019,200", "357,578", "232.17"),
    ColumnGroupingRow("Ireland", "IE", "4,857,000", "70,273", "69.12"),
    ColumnGroupingRow("Mexico", "MX", "126,577,691", "1,972,550", "64.17"),
    ColumnGroupingRow("Japan", "JP", "126,317,000", "377,973", "334.20"),
    ColumnGroupingRow("France", "FR", "67,022,000", "640,679", "104.61"),
    ColumnGroupingRow("United Kingdom", "GB", "67,545,757", "242,495", "278.54"),
    ColumnGroupingRow("Russia", "RU", "146,793,744", "17,098,246", "8.59"),
    ColumnGroupingRow("Nigeria", "NG", "200,962,417", "923,768", "217.55"),
    ColumnGroupingRow("Brazil", "BR", "210,147,125", "8,515,767", "24.68"),
)

private external interface ColumnGroupingColumn {
    var id: String
    var label: String
    var minWidth: Length
    var align: TableCellAlign
}

private external interface ColumnGroupingRow {
    var name: String
    var code: String
    var population: String
    var size: String
    var density: String
}

private fun ColumnGroupingColumn(
    id: String,
    label: String,
    minWidth: Length,
    align: TableCellAlign,
): ColumnGroupingColumn = jso {
    this.id = id
    this.label = label
    this.minWidth = minWidth
    this.align = align
}

private fun ColumnGroupingRow(
    name: String,
    code: String,
    population: String,
    size: String,
    density: String,
): ColumnGroupingRow = jso {
    this.name = name
    this.code = code
    this.population = population
    this.size = size
    this.density = density
}
