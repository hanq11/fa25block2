const baseUrl = "http://localhost:8080/sinh-vien"

export const fetchAllSinhVien = async () => {
    const response = await fetch(`${baseUrl}/hien-thi`);
    if(!response.ok) {
        throw new Error(response.status + ": " + await response.text())
    }
    return await response.json();
}

export const fetchAllLopHoc = async () => {
    const response = await fetch(`${baseUrl}/lop-hoc`);
    if(!response.ok) {
        throw new Error(response.status + ": " + await response.text())
    }
    return await response.json();
}

export const fetchSinhVienById = async (id) => {
    const response = await fetch(`${baseUrl}/${id}`);
    if(!response.ok) {
        throw new Error(response.status + ": " + await response.text())
    }
    return await response.json();
}

export const addSinhVien = async (sinhVien) => {
    const response = await fetch(`${baseUrl}/them`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(sinhVien)
    });
    if(!response.ok) {
        throw new Error(response.status + ": " + await response.text())
    }
}

export const updateSinhVien = async (sinhVien) => {
    const response = await fetch(`${baseUrl}/sua`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(sinhVien)
    });
    if(!response.ok) {
        throw new Error(response.status + ": " + await response.text())
    }
}

export const deleteSinhVien = async (id) => {
    const response = await fetch(`${baseUrl}/xoa?id=${id}`, {
        method: "DELETE"
    });
    if(!response.ok) {
        throw new Error(response.status + ": " + await response.text())
    }
}
