package com.example.appdyanmictables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;

public class MainActivity extends AppCompatActivity {
    Button btn_make;
    EditText row, column;
    TableLayout table;
    String[][] cell;
    int num_columns;
    int num_rows;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_make = findViewById(R.id.btn_make);
        row = findViewById(R.id.n_row);
        column = findViewById(R.id.n_column);

        table = findViewById(R.id.table);
        table.setStretchAllColumns(true);
        table.bringToFront();
        table.isColumnShrinkable(0);

        btn_make.setOnClickListener(view -> {
            if (!row.getText().toString().isEmpty()&&!column.getText().toString().isEmpty()){
                num_rows = Integer.parseInt(row.getText().toString());
                num_columns = Integer.parseInt(column.getText().toString());
                cell = new String[num_columns][num_rows];
                make_table_dinamic();
            }
        });
    }

    private void make_table_dinamic() {
        DinamicTables dinamicTables = new DinamicTables(this);
        dinamicTables.Show_table(cell,num_rows, num_rows, table);
    }
}