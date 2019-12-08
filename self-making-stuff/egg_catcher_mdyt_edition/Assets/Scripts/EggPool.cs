using UnityEngine;
using System.Collections;

public class EggPool : MonoBehaviour
{
    public GameObject eggPrefab;
    private Egg leftEgg;
    private Egg rightEgg;
    private Vector2 eggLeftPosition = new Vector2(-4, 6);
    private Vector2 eggRightPosition = new Vector2(4, 6);

    void Start()
    {
        GameObject leftEgg = (GameObject)Instantiate(eggPrefab, eggLeftPosition, Quaternion.identity);
        GameObject rightEgg = (GameObject)Instantiate(eggPrefab, eggRightPosition, Quaternion.identity);
        this.leftEgg = leftEgg.GetComponent<Egg>();
        this.rightEgg = rightEgg.GetComponent<Egg>();
    }
}