package com.example.appdyanmictables;

import android.content.Context;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;

public class DinamicTables {

    Context context;
    public DinamicTables(Context context){
        this.context = context;
    }

    public void Show_table(String[][] cell, int num_row, int num_col, TableLayout table){
        for (int r = 0; r<num_row; r++){
            TableRow tableRow = new TableRow(context);
            TableRow.LayoutParams parm_row = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            tableRow.setLayoutParams(parm_row);
            table.addView(tableRow);
            for (int c = 0; c<num_col; c++){

                //Replace it with TextView Button ...
                EditText edit_cell = new EditText(context);
                edit_cell.setText("");

                //Input Type for the EditText
                //edit_cell.setInputType(InputType.TYPE_CLASS_NUMBER|InputType.TYPE_NUMBER_FLAG_DECIMAL|InputType.TYPE_CLASS_TEXT);

                int final_c = c;
                int final_r = r;
                edit_cell.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    }
                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {
                        String aux = editable.toString();
                        if (aux.equals("")){
                            aux = "";
                        }
                        if (aux.isEmpty()){
                            aux = "";
                        }
                        cell[final_c][final_r] = aux;
                    }
                });
                TableRow.LayoutParams params_cell = new TableRow.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT,1);
                edit_cell.setLayoutParams(params_cell);
                tableRow.addView(edit_cell);
            }
        }
    }
}
