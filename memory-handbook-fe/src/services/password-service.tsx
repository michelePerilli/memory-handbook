import axios from "../axios";
import PasswordDto from "../model/password-dto";


export class PasswordService {
    public async list() {
        let axiosResponse = await axios.get<PasswordDto[]>("/password/list");
        return axiosResponse.data;
    }

    public async insert() {
        let axiosResponse = await axios.put<PasswordDto[]>("/password");
        return axiosResponse.data;
    }

    public async find() {
        let axiosResponse = await axios.post<PasswordDto[]>("/password");
        return axiosResponse.data;
    }
}

export default PasswordService;