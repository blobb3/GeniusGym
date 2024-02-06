/*
// Beispiel für Funktion auslagern (Unterricht)
import {Task} from "@/model/task";
import axios from "axios";
import {onMounted, ref } from "vue";

// jedes composables hat immer eine Funktion die exporitert wird
export function useTasks() {
    //hier am beispeil von tasks

    const tasks = ref<Task[]>([]);
        
        function addTask() {
            //tasks.value.push("App programmieren")
        }

        function getTasks() {
            axios.get('https:///Fswd-tas-list-943648062cbb.herokuapp.com/api/tasks')
            .then( response => {
                tasks.value = response.data;
            })
        }
    
        onMounted(() => { getTasks()})

    return { tasks, getTasks, addTask};
}

//auf Seite, wo man dann die Funktion braucht:
 

import { useTasks} from '../composables/useTasks'

const { tasks, getTasks, addTask} = useTasks; 
// man muss nicht sämgliche rückgabewerte verwenden, man kann auch nur funktionen aufrufen, die man braucht

*/