const baseUrl = "http://localhost:8080/sinh-vien"

export const getAll = async () => {
    const response = await fetch(`${baseUrl}/hien-thi`);
    return await response.json();
}