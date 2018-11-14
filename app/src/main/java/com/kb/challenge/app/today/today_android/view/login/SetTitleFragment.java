package com.kb.challenge.app.today.today_android.view.login;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.kb.challenge.app.today.today_android.R;

public class SetTitleFragment extends Fragment {

    private EditText et_set_title_hole;
    private EditText et_set_title_amount;
    private OnEditTitleSetListener onEditTitleSetListener;
    private LinearLayout ll_settitle_over_amount_error;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settitle, container, false);
        et_set_title_hole = (EditText)view.findViewById(R.id.et_set_title_hole);

        ll_settitle_over_amount_error = view.findViewById(R.id.ll_settitle_over_amount_error);

        et_set_title_amount = (EditText)view.findViewById(R.id.et_set_title_amount);
        et_set_title_amount.addTextChangedListener(new CustomTextWatcher(et_set_title_amount,ll_settitle_over_amount_error));

        et_set_title_hole.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // 입력되는 텍스트에 변화가 있을 때
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                onEditTitleSetListener.onTitleSet(et_set_title_hole.getText().toString());
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // 입력하기 전에
            }
        });


        et_set_title_amount.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // 입력되는 텍스트에 변화가 있을 때
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                onEditTitleSetListener.onAmountSet(Integer.parseInt(et_set_title_amount.getText().toString()));
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // 입력하기 전에
            }
        });


        return view;
    }
    public interface OnEditTitleSetListener{
        void onTitleSet(String title);
        void onAmountSet(int amount);
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof SetTitleFragment.OnEditTitleSetListener) {
            onEditTitleSetListener = (SetTitleFragment.OnEditTitleSetListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement onEditNameSetListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onEditTitleSetListener = null;

    }
}