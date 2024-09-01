import { useState } from "react";
import axiosInstance from "../axiosConfig";
import { QueryClient, useMutation } from "@tanstack/react-query";

const PERSONNEL_URL = 'api/admin/personnel'

const AddPersonnel = () => {

  // TODO these need to be updated according to the project requirements
  const [personnel_id, setId] = useState('');
  const [name, setName] = useState('');
  const [office, setOffice] = useState('');
  const [email, setEmail] = useState('');
  const [phone, setPhone] = useState('');
  const [department, setDepartment] = useState('');

  const queryClient = new QueryClient();

  const patchData = async () => {
    try {
      const response = await axiosInstance.patch(PERSONNEL_URL, { personnel_id, department, name, phone, office, email });
      console.log(response);
    } catch (error) {
      console.error("Error updating profile", error);
    }
  }

  const { mutateAsync: mutate } = useMutation({
    mutationFn: patchData,
    onSuccess: () => {
      queryClient.invalidateQueries(["employees"]);
    },
  })

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      await mutate();
    } catch (e) {
      console.error(e);
    }
  }

  //TODO Update form according to project requirements
  return (
    <div className="add-personnel bg-gray-100 p-8 rounded-lg shadow-md">
      <h1 className="text-2xl font-bold text-blue-700 mb-6">Add Personnel</h1>
      <form onSubmit={handleSubmit}>
        <div className="mb-4">
          <label className="block text-gray-700 mb-2">Personnel Id:</label>
          <input
            type="text"
            required
            value={personnel_id}
            onChange={(e) => setId(e.target.value)}
            className="w-full p-2 border border-gray-300 rounded focus:outline-none focus:ring-2 focus:ring-blue-500"
          />
        </div>
        <div className="mb-4">
          <label className="block text-gray-700 mb-2">Personnel name:</label>
          <input
            type="text"
            required
            value={name}
            onChange={(e) => setName(e.target.value)}
            className="w-full p-2 border border-gray-300 rounded focus:outline-none focus:ring-2 focus:ring-blue-500"
          />
        </div>
        <div className="mb-4">
          <label className="block text-gray-700 mb-2">Personnel department:</label>
          <input
            type="text"
            required
            value={department}
            onChange={(e) => setDepartment(e.target.value)}
            className="w-full p-2 border border-gray-300 rounded focus:outline-none focus:ring-2 focus:ring-blue-500"
          />
        </div>
        <div className="mb-4">
          <label className="block text-gray-700 mb-2">Personnel OfficeNumber:</label>
          <input
            type="text"
            required
            value={office}
            onChange={(e) => setOffice(e.target.value)}
            className="w-full p-2 border border-gray-300 rounded focus:outline-none focus:ring-2 focus:ring-blue-500"
          />
        </div>
        <div className="mb-4">
          <label className="block text-gray-700 mb-2">Personnel Phone number:</label>
          <input
            type="text"
            required
            value={phone}
            onChange={(e) => setPhone(e.target.value)}
            className="w-full p-2 border border-gray-300 rounded focus:outline-none focus:ring-2 focus:ring-blue-500"
          />
        </div>
        <div className="mb-4">
          <label className="block text-gray-700 mb-2">Personnel email:</label>
          <input
            type="text"
            required
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            className="w-full p-2 border border-gray-300 rounded focus:outline-none focus:ring-2 focus:ring-blue-500"
          />
        </div>
        <button
          type="submit"
          className="w-full bg-yellow-500 text-white p-2 rounded hover:bg-yellow-600 focus:outline-none focus:ring-2 focus:ring-yellow-400"
        >
          Submit
        </button>
      </form>
    </div>
  );
}

export default AddPersonnel;
