import PasswordDto from "../model/password-dto";
import {createAsyncThunk, createSlice} from "@reduxjs/toolkit";
import PasswordService from "../services/password-service";

interface PasswordState {
    state?: PasswordDto,
    searchResult: PasswordDto[],
    searchState: string,
}

const initialState: PasswordState = {
    searchState: "",
    searchResult: [],
}

const api = new PasswordService();

export const listaPassword = createAsyncThunk(
    'password/list',
    async () => {
        return await api.list();
    }
)

export default createSlice({
    name: 'password/list',
    reducers: {},
    initialState: initialState,
    extraReducers: (builder) => {
        builder.addCase(listaPassword.fulfilled, (state, action) => {
            state.searchResult = action.payload;
        });
    }
}).reducer;
